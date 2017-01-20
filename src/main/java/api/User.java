package api;

import db.DatabaseOperator;
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
			status.put("code", String.valueOf(HttpServletResponse.SC_OK));
			status.put("message", "query user successfully");
			jsonObject.put("meta", status);
			jsonObject.put("data", writer);
			resp.setStatus(HttpServletResponse.SC_OK);
		} catch (RuntimeException re) {
			LoggerFactory.getLogger(User.class).error("fatal error:", re);
			status.put("code", String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
			status.put("message", "query user successfully");
			jsonObject.put("meta", status);
			jsonObject.put("data", "_");
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		try (ServletOutputStream out = resp.getOutputStream()) {
			out.write(jsonObject.toString().getBytes());
			out.flush();
			out.close();
		}
	}
}
