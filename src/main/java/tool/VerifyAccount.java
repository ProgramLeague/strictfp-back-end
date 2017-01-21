package tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class VerifyAccount {
	static {
		logger = LoggerFactory.getLogger(VerifyAccount.class);
	}

	private static VerifyAccount instance;
	private static final Logger logger;

	private VerifyAccount() {
		//TODO
	}

	public static VerifyAccount getInstance() {
		if (instance == null) instance = new VerifyAccount();
		return instance;
	}

	public boolean verityZhihuImportance(String username) {
		// FIXME 如果这人的 粉丝数>=50 && 赞数>=40 则返回true，否则返回false。
		// 可以参考：https://github.com/shanelau/zhihu
		return true;
	}

	public boolean verityStackOverFlowImportance(String username) {
		// FIXME 如果这人的 回答数>=5 则返回true，否则返回false。
		// 可以参考：https://api.stackexchange.com/docs
		return true;
	}

	public boolean verityZhihuAccount(String username) {
		return verity("https://www.zhihu.com/people/", username);
	}

	public boolean verityStackOverFlowAccount(String username) {
		//TODO 这破栈溢出的地址不是直接/user/XXX，它是/users/什么鬼数字/XXX、我的方法就用不了了。交给磷吧！
		return true;
	}

	public boolean verityGitHubAccount(String username) {
		return verity("https://github.com/", username);
	}

	private boolean verity(String contextPath, String username) {
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
