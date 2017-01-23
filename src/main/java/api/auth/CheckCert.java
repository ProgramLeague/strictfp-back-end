package api.auth;

import db.DatabaseOperator;
import db.obj.Pair;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tool.VerifyAccount;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class CheckCert extends HttpServlet {
	static {
		pattern = Pattern.compile(
				"[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?"
		);
	}

	@NotNull
	private Set<String> errorMessage = new HashSet<>();
	private static final Pattern pattern;

	public CheckCert() {
	}

	@Override
	protected void doPost(
			@NotNull HttpServletRequest req,
			@NotNull HttpServletResponse resp)
			throws ServletException, IOException {
		// init
		ServletOutputStream sos = resp.getOutputStream();
		Base64.Decoder decoder = Base64.getDecoder();
		JSONObject jsonObject = new JSONObject();
		Map<String, String> status = new HashMap<>();
		// get info
		String username = new String(
				decoder.decode(req.getParameter("uname")),
				StandardCharsets.UTF_8
		);
		String email = new String(
				decoder.decode(req.getParameter("email")),
				StandardCharsets.UTF_8
		);
		String zhihu_username = new String(
				decoder.decode(req.getParameter("zhihu")),
				StandardCharsets.UTF_8
		);
		String github_username = new String(
				decoder.decode(req.getParameter("github")),
				StandardCharsets.UTF_8
		);
		String stackoverflow_username = new String(
				decoder.decode(req.getParameter("stackoverflow")),
				StandardCharsets.UTF_8
		);
		String brief = new String(
				decoder.decode(req.getParameter("brief")),
				StandardCharsets.UTF_8
		);
		String introduce = new String(
				decoder.decode(req.getParameter("introduce")),
				StandardCharsets.UTF_8
		);
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

	private void verify(
			@NotNull @NonNls String username,
			@NotNull @NonNls String email,
			@NotNull @NonNls String zhihu_username,
			@NotNull @NonNls String github_username,
			@NotNull @NonNls String stackoverflow_username,
			@NotNull @NonNls String brief,
			@NotNull @NonNls String introduce) {
		//FIXME 就是我在群上说的想法。在这里告诉前端让它绘制一个等待界面，然后在本方法末尾放一个玩意告诉前端等待界面可以移除了。
		// judge validity
		if (DatabaseOperator.getWriter(new Pair("uname", "=\"" + username + "\"")) != null)
			errorMessage.add("user already exists");
		if (email.length() >= 0xFF) errorMessage.add("email length must less than 255");
		if (!pattern.matcher(email).find()) errorMessage.add("email illegal");
		if (zhihu_username.length() >= 0xFF) errorMessage.add("zhihu username length must less than 255");
		if (github_username.length() >= 0xFF) errorMessage.add("github username length must less than 255");
		if (stackoverflow_username.length() >= 0xFF)
			errorMessage.add("stackoverflow username length must less than 255");
		if (brief.length() >= 0xFF) errorMessage.add("brief length must less than 255");
		if (introduce.length() >= 0xFFFF) errorMessage.add("introduce length must less than " + 0xFFFF);
		// verify account
		if (!zhihu_username.equals("_"))
			if (VerifyAccount.getInstance().verifyZhihuAccount(zhihu_username))
				errorMessage.add("no such zhihu account");
		if (!github_username.equals("_"))
			if (VerifyAccount.getInstance().verifyGitHubAccount(github_username))
				errorMessage.add("no such github account");
		if (!stackoverflow_username.equals("_"))
			if (VerifyAccount.getInstance().verifyStackOverFlowAccount(stackoverflow_username))
				errorMessage.add("no such stackoverflow account");
	}
}
