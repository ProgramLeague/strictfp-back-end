package api.auth;

import db.DatabaseOperator;
import db.obj.Pair;
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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class CheckCert extends HttpServlet {
	private Set<String> errorMessage = new HashSet<>();

	public CheckCert() {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletOutputStream sos = resp.getOutputStream();
		BASE64Decoder decoder = new BASE64Decoder();
		JSONObject jsonObject = new JSONObject();
		Map<String, String> status = new HashMap<>();
		// get info
		String username = new String(decoder.decodeBuffer(req.getParameter("uname")), StandardCharsets.UTF_8);
		String email = new String(decoder.decodeBuffer(req.getParameter("email")), StandardCharsets.UTF_8);
		String zhihu_username = new String(decoder.decodeBuffer(req.getParameter("zhihu")));
		String github_username = new String(decoder.decodeBuffer(req.getParameter("github")));
		String stackoverflow_username = new String(decoder.decodeBuffer(req.getParameter("stackoverflow")));
		String brief = new String(decoder.decodeBuffer(req.getParameter("brief")));
		String introduce = new String(decoder.decodeBuffer(req.getParameter("introduce")));
		// verify info
		verify(username, email, zhihu_username, github_username, stackoverflow_username, brief, introduce);
		status.put("code", String.valueOf(HttpServletResponse.SC_OK));
		status.put("message", "verify user info successfully");
		jsonObject.put("meta", status);
		jsonObject.put("data", errorMessage);
		sos.write(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
		sos.flush();
		sos.close();
	}

	private void verify(String username, String email, String zhihu_username, String github_username,
	                    String stackoverflow_username, String brief, String introduce) {
		//FIXME 就是我在群上说的想法。在这里告诉前端让它绘制一个等待界面，然后在本方法末尾放一个玩意告诉前端等待界面可以移除了。
		// judge validity
		if (DatabaseOperator.getWriter(new Pair("uname", "=\"" + username + "\"")) != null)
			errorMessage.add("user already exists");
		if (email.length() >= 255) errorMessage.add("email length must less than 255");
		if (!Pattern.compile("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w]" +
				"(?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")
				.matcher(email)
				.find()) errorMessage.add("email illegal");
		if (zhihu_username.length() >= 255) errorMessage.add("zhihu username length must less than 255");
		if (github_username.length() >= 255) errorMessage.add("github username length must less than 255");
		if (stackoverflow_username.length() >= 255)
			errorMessage.add("stackoverflow username length must less than 255");
		if (brief.length() >= 255) errorMessage.add("brief length must less than 255");
		if (introduce.length() >= 65535) errorMessage.add("introduce length must less than 65535");
		// verify account
		if (!zhihu_username.equals("_"))
			if (VerifyAccount.getInstance().verityZhihuAccount(zhihu_username))
				errorMessage.add("no such zhihu account");
		if (!github_username.equals("_"))
			if (VerifyAccount.getInstance().verityGitHubAccount(github_username))
				errorMessage.add("no such github account");
		if (!stackoverflow_username.equals("_"))
			if (VerifyAccount.getInstance().verityStackOverFlowAccount(stackoverflow_username))
				errorMessage.add("no such stackoverflow account");
	}
}
