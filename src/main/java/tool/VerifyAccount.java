package tool;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import static tool.Tools.getValidNumber;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
@SuppressWarnings({"WeakerAccess", "SameParameterValue"})
public class VerifyAccount {
	static {
		logger = LoggerFactory.getLogger(VerifyAccount.class);
	}

	private static VerifyAccount instance;
	private static final Logger logger;
	private static final String SOFApiRoot = "http://api.stackexchange.com/2.2/";
	private static final String ZhihuApiRoot = "https://www.zhihu.com/node/MemberProfileCardV2?params={\"url_token\"%%3A\"%s\"}";

	private VerifyAccount() {
	}

	@NotNull
	public static VerifyAccount getInstance() {
		if (instance == null) instance = new VerifyAccount();
		return instance;
	}

	//FIXME: 既然返回是布尔干嘛说是重要性。。直接checkIfIsIpInZhihu
	// 听说这里很慢
	public boolean verifyZhihuImportance(@NotNull @NonNls String username) {
		try {
			IntTokenizer tokenizer = null;
			Document page = Jsoup.parse(
					new URL(String.format(ZhihuApiRoot,username)),
					5000
			);
			Elements root = page.select("div[class='meta']");
			tokenizer = IntTokenizer.of(root.text());
			int reputationPoint = tokenizer.nextToken();
			tokenizer.nextToken();
			int likesPoint = tokenizer.nextToken();
			return (reputationPoint >= 50 && likesPoint >= 40);
		} catch (IOException e) {
			throw new RuntimeException("unable to fetch data from zhihu", e);
		}
	}

	public boolean verifyStackOverFlowImportance(@NotNull @NonNls String username) {
		try {
			String url = SOFApiRoot + String.format(
					"users?order=asc&min=%s&max=%s&sort=name&inname=%s&site=stackoverflow&filter=!9YdnSAffT",
					username,
					username,
					username
			);
			HttpURLConnection conn = HttpURLConnection.class.cast(new URL(url).openConnection());
			if(conn.getResponseCode() != 200) return false;
			JSONTokener tokener = new JSONTokener(new GZIPInputStream(conn.getInputStream()));
			JSONObject object = JSONObject.class.cast(tokener.nextValue());
			conn.disconnect();
			if (object.getJSONArray("items").length() == 0)
				return false;
			else {
				JSONObject user = JSONObject.class.cast(object.getJSONArray("items").get(0));
				return user.getInt("answer_count") >= 5;
			}
		} catch (IOException e) {
			throw new RuntimeException("unable to fetch data from stackoverflow", e);
		}
	}

	public boolean verifyZhihuAccount(@NotNull @NonNls String username) {
		return verify("https://www.zhihu.com/people/", username);
		//FIXME: 由于严重违反知乎社区规范，该用户帐号已被停用。 这个是返回200的，测试账号fu-qian-yi-55
		//回上 ， 这个账号测试返回404 。。。。。 具体去看test case
	}

	public boolean verifyStackOverFlowAccount(@NotNull @NonNls String username) {
		try {
			String url = SOFApiRoot + String.format(
					"users?order=asc&min=%s&max=%s&sort=name&inname=%s&site=stackoverflow",
					username,
					username,
					username
			);
			HttpURLConnection conn = HttpURLConnection.class.cast(new URL(url).openConnection());
			if (conn.getResponseCode() != 200) return false;
			JSONTokener tokener = new JSONTokener(new GZIPInputStream(conn.getInputStream()));
			// note that it was compressed
			JSONObject object = JSONObject.class.cast(tokener.nextValue());
			conn.disconnect();
			return object.getJSONArray("items").length() != 0;
			// 特判一下吧还是。。昨晚查询不存在用户返回的是200 ...和一个json
			// 上面打这段注释的，没注意到我判断了返回的结果是否包含有效用户吗 =-= , bug 'fixed'
		} catch (IOException e) {
			throw new RuntimeException("unable to fetch data from stackoverflow", e);
		}
	}

	public boolean verifyGitHubAccount(@NotNull @NonNls String username) {
		return verify("https://github.com/", username);
	}

	private boolean verify(
			@NotNull @NonNls String contextPath,
			@NotNull @NonNls String username) {
		try {
			URL url = new URL(contextPath + username);
			HttpURLConnection connection = HttpURLConnection.class.cast(url.openConnection());
			connection.connect();
			return connection.getResponseCode() == 200;
			// 要是人家不404 呢？
			// 其实之前写的是 if (reCo == 404) return false; else return true...我就给改了 ---ice
			// 改得好，搞个大新闻批判一番 - 磷
		} catch (MalformedURLException e) {
			logger.warn("URL exception: ", e);
			return false;
		} catch (IOException ex) {
			logger.warn("IO exception: ", ex);
			return false;
		}
	}
}
