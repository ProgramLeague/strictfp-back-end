package api;

import test.db.DatabaseOperator;
import test.db.obj.Author;
import test.db.obj.Pair;
import org.jetbrains.annotations.NotNull;
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
	protected void doGet(
			@NotNull HttpServletRequest req,
			@NotNull HttpServletResponse resp
	) throws ServletException, IOException {
		String name = req.getParameter("name");
		JSONObject jsonObject = new JSONObject();
		Map<String, String> status = new HashMap<>();
		try {
			Author author = DatabaseOperator.getWriter(new Pair("name", "=" + name));
			if (author == null) throw new RuntimeException("No such user.");
			// get info
			int Id = author.getId();
			String avatarURL = author.getAvatar().toString();
			int genderInt = author.getGender();
			String writerName = author.getName();
			String motto = author.getMotto();
			// build map
			Map<String, String> writerInfo = new HashMap<>();
			writerInfo.put("id", String.valueOf(Id));
			writerInfo.put("gender", String.valueOf(genderInt));
			writerInfo.put("name", writerName);
			writerInfo.put("avatar", avatarURL);
			writerInfo.put("motto", motto);
			// build status
			status.put("code", String.valueOf(HttpServletResponse.SC_OK));
			status.put("message", "SUCCESS - query userinfo");
			// build object
			jsonObject.put("meta", status);
			jsonObject.put("data", writerInfo);
			resp.setStatus(HttpServletResponse.SC_OK);
		} catch (RuntimeException re) {
			LoggerFactory.getLogger(User.class).error("fatal error:", re);
			// build status
			status.put("code", String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
			status.put("message", "Internal server error: " + re.getMessage());
			// build object
			jsonObject.put("meta", status);
			jsonObject.put("data", "_");
			//FIXME: replace with constant
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		// write object
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		try (ServletOutputStream out = resp.getOutputStream()) {
			out.write(jsonObject.toString().getBytes(StandardCharsets.UTF_8)); // how can you sure if it is not utf-8 ?
			out.flush();
			// out.close();
		}
	}
}
