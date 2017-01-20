package api;

import db.DatabaseOperator;
import db.obj.Gender;
import db.obj.Pair;
import db.obj.Writer;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eldath on 2017/1/20 0020.
 *
 * @author Eldath
 */
public class User extends HttpServlet {
	public User() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		JSONObject jsonObject = new JSONObject();
		Map<String, String> status = new HashMap<>();
		try {
			Writer writer = DatabaseOperator.getWriter(new Pair("name", "=" + name));
			int Id = writer.getId();
			String avatarURL = writer.getAvatarURL().toString();
			Gender gender = writer.getGender();
			String writerName = writer.getName();
			String motto = writer.getMotto();
			Map<String, String> writerInfo = new HashMap<>();
			writerInfo.put("Id", String.valueOf(Id));
			writerInfo.put("gender", String.valueOf(gender.getInt()));
			writerInfo.put("name", writerName);
			writerInfo.put("avatarURL", avatarURL);
			writerInfo.put("motto", motto);
			status.put("code", String.valueOf(HttpServletResponse.SC_OK));
			status.put("message", "query user successfully");
			jsonObject.put("meta", status);
			jsonObject.put("data", writerInfo);
			resp.setStatus(HttpServletResponse.SC_OK);
		} catch (RuntimeException re) {
			LoggerFactory.getLogger(User.class).error("fatal error:", re);
			status.put("code", String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
			status.put("message", "query user successfully");
			jsonObject.put("meta", status);
			jsonObject.put("data", "_");
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		try (ServletOutputStream out = resp.getOutputStream()) {
			out.write(jsonObject.toString().getBytes(StandardCharsets.UTF_8)); // how can you sure if it is not utf-8 ?
			out.flush();
			out.close();
		}
	}
}
