package tool;

import com.sun.xml.internal.messaging.saaj.util.CharReader;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.CharArrayReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Phosphorus15
 */
public class VerifyAccount {
	static {
		logger = LoggerFactory.getLogger(VerifyAccount.class);
	}

	private static VerifyAccount instance;
	private static final Logger logger;
	private static final String apiRoot = "http://api.stackexchange.com/2.2/";

	private VerifyAccount() {
	}

	@NotNull
	public static VerifyAccount getInstance() {
		if (instance == null) instance = new VerifyAccount();
		return instance;
	}

	private static int getValidNumber(@NotNull @Nls char[] content) throws IOException {
		CharArrayReader reader = new CharReader(content, content.length);
		int result = 0;
		int current = reader.read();
		while (!(current >= '0' && current <= '9')) current = reader.read();
		while (current >= '0' && current <= '9') {
			result = (result << 3) + (result << 1) + (current - '0'); // equal to result * 10
			current = reader.read();
		}
		reader.close();
		return result;
	}

	public boolean verifyZhihuImportance(@NotNull @NonNls String username) {
		// FIXME 如果这人的 粉丝数>=50 && 赞数>=40 则返回true，否则返回false。
		try {
			Document page = Jsoup.parse(new URL("https://www.zhihu.com/people/" + username + "/answers/"),
					5000);
			Elements reputation = page.select("div[class='IconGraf']");
			String reputationStr = reputation.first().text().trim();
			int reputationPoint = getValidNumber(reputationStr.toCharArray());
			Elements likes = page.select("div[class='NumberBoard-value']");
			int likesPoint = getValidNumber(likes.last().text().trim().toCharArray());
			return (reputationPoint >= 50 && likesPoint >= 40);
		} catch (IOException e) {
			throw new RuntimeException("unable to fetch data from zhihu", e);
		}
	}

	public boolean verifyStackOverFlowImportance(@NotNull @NonNls String username) {
		try {
			String url = apiRoot + String.format("users?order=asc&min=%s&max=%s&sort=name&inname=%s&site=stackoverflow&filter=!9YdnSAffT", username, username, username);
			HttpURLConnection conn = HttpURLConnection.class.cast(new URL(url).openConnection());
			JSONTokener tokener = new JSONTokener(new GZIPInputStream(conn.getInputStream())); // note that it was compressed
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
	}

	public boolean verifyStackOverFlowAccount(@NotNull @NonNls String username) {
		try {
			String url = apiRoot + String.format("users?order=asc&min=%s&max=%s&sort=name&inname=%s&site=stackoverflow",
					username, username, username);
			HttpURLConnection conn = HttpURLConnection.class.cast(new URL(url).openConnection());
			JSONTokener tokener = new JSONTokener(new GZIPInputStream(conn.getInputStream())); // note that it was compressed
			JSONObject object = JSONObject.class.cast(tokener.nextValue());
			conn.disconnect();
			return object.getJSONArray("items").length() != 0;
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
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			int responseCode = connection.getResponseCode();
			return !(responseCode == 404);
		} catch (MalformedURLException e) {
			logger.warn("URL exception: ", e);
			return false;
		} catch (IOException ex) {
			logger.warn("IO exception: ", ex);
			return false;
		}
	}
}
