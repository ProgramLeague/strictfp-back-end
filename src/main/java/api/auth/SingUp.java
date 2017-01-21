package api.auth;

import org.json.JSONObject;
import sun.misc.BASE64Decoder;
import tool.VerifyAccount;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class SingUp extends HttpServlet {
	private String errorMessage = "";
	private ServletOutputStream sos;

	public SingUp() {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		sos = resp.getOutputStream();
		BASE64Decoder decoder = new BASE64Decoder();
		JSONObject jsonObject = new JSONObject();
		Map<String, String> status = new HashMap<>();
		String salt;
		// get info
		String email = new String(decoder.decodeBuffer(req.getParameter("email")), StandardCharsets.UTF_8);
		String zhihu_username = new String(decoder.decodeBuffer(req.getParameter("zhihu")));
		String github_username = new String(decoder.decodeBuffer(req.getParameter("github")));
		String stackoverflow_username = new String(decoder.decodeBuffer(req.getParameter("stackoverflow")));
		String brief = new String(decoder.decodeBuffer(req.getParameter("brief")));
		String introduce = new String(decoder.decodeBuffer(req.getParameter("introduce")));
		// verify info
		verify(email, zhihu_username, github_username, stackoverflow_username, brief, introduce);
	}

	private void verify(String email, String zhihu_username, String github_username,
	                    String stackoverflow_username, String brief, String introduce) {
		//TODO 就是我在群上说的想法。在这里告诉前端让它绘制一个等待界面，然后在本方法末尾放一个玩意告诉前端等待界面可以移除了。
		// judge validity
		if (email.length() >= 255) errorMessage += "email length must less than 255";
		addComma();
		if (!Pattern.compile("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w]" +
				"(?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")
				.matcher(email)
				.find()) errorMessage += "email illegal";
		addComma();
		if (zhihu_username.length() >= 255) errorMessage += "zhihu username length must less than 255";
		addComma();
		if (github_username.length() >= 255) errorMessage += "github username length must less than 255";
		addComma();
		if (stackoverflow_username.length() >= 255)
			errorMessage += "stackoverflow username length must less than 255";
		addComma();
		if (brief.length() >= 255) errorMessage += "brief length must less than 255";
		addComma();
		if (introduce.length() >= 65535) errorMessage += "introduce length must less than 65535";
		addComma();
		// verify account
		if (!zhihu_username.equals("_"))
			if (VerifyAccount.getInstance().verityZhihuAccount(zhihu_username))
				errorMessage += "no such zhihu account";
		addComma();
		if (!github_username.equals("_"))
			if (VerifyAccount.getInstance().verityGitHubAccount(github_username))
				errorMessage += "no such github account";
		addComma();
		if (!stackoverflow_username.equals("_"))
			if (VerifyAccount.getInstance().verityStackOverFlowAccount(stackoverflow_username))
				errorMessage += "no such stackoverflow account";
		addComma();
	}

	private void addComma() {
		if (!errorMessage.isEmpty())
			errorMessage = errorMessage + ",";
	}
}
