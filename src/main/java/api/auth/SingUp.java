package api.auth;

import db.DatabaseOperator;
import org.json.JSONObject;
import sun.misc.BASE64Decoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class SingUp extends HttpServlet {
	public SingUp() {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		JSONObject jsonObject = new JSONObject();
		Map<String, String> status = new HashMap<>();
		String errorMessage = "", salt;
		// get info
		String email = new String(decoder.decodeBuffer(req.getParameter("email")));
		String zhihu_username = new String(decoder.decodeBuffer(req.getParameter("zhihu")));
		String github_username = new String(decoder.decodeBuffer(req.getParameter("github")));
		String stackoverflow_username = new String(decoder.decodeBuffer(req.getParameter("stackoverflow")));
		String brief = new String(decoder.decodeBuffer(req.getParameter("brief")));
		String introduce = new String(decoder.decodeBuffer(req.getParameter("introduce")));
		// judge validity
		if (email.length() >= 255) errorMessage += "email length must less than 255" + ",";
		if (!Pattern.compile("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w]" +
				"(?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")
				.matcher(email)
				.find()) errorMessage += "email illegal,";
		if (zhihu_username.length() >= 255) errorMessage += "zhihu username length must less than 255,";
		if (github_username.length() >= 255) errorMessage += "github username length must less than 255,";
		if (stackoverflow_username.length() >= 255)
			errorMessage += "stackoverflow username length must less than 255,";
		if (brief.length() >= 255) errorMessage += "brief length must less than 255,";
		if (introduce.length() >= 65535) errorMessage += "introduce length must less than 65535";
	}
}
