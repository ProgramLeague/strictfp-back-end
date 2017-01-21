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
	private static VerifyAccount instance = null;
	private static Logger logger = LoggerFactory.getLogger(VerifyAccount.class);

	private VerifyAccount() {
		//TODO
	}

	public static VerifyAccount getInstance() {
		if (instance == null) instance = new VerifyAccount();
		return instance;
	}

	public boolean verityZhihuAccount(String username) {
		return verity("https://www.zhihu.com/people/", username);
	}

	public boolean verityStackOverFlowAccount(String username) {
		//TODO ����ջ����ĵ�ַ����ֱ��/user/XXX������/users/ʲô������/XXX���ҵķ������ò����ˡ�
		//TODO �����װɣ�
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
