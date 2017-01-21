package api;

import db.DatabaseOperator;
import db.obj.Article;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Eldath on 2017/1/17 0017.
 * <p>
 * 自己看 HttpServlet ,
 * do+ 字符串 就是会被处理的请求类型(例如实现了 doGet 就会处理 GET ,实现了 doPost 就会处理 POST ).
 *
 * @author Eldath
 */
public class TimeLine extends HttpServlet {
	public TimeLine() {
	}

	@Override
	protected void doGet(
			@NotNull HttpServletRequest request,
			@NotNull HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		LocalDate start = LocalDate.parse(request.getParameter("start"));
		LocalDate end = LocalDate.parse(request.getParameter("end"));
		JSONObject jsonObject = new JSONObject();
		Vector<Article> articles = new Vector<>();
		Map<String, String> status = new HashMap<>();
		try {
			// get info
			for (LocalDate nowDate = start;
			     nowDate.isBefore(end) || nowDate.isEqual(end);
			     nowDate = nowDate.plusDays(1)) {
				Article nowArticle = DatabaseOperator.getArticle(nowDate);
				if (nowArticle == null) break;
				articles.add(nowArticle);
			}
			if(articles.isEmpty()) throw new RuntimeException("no article now");
			// build status
			status.put("code", String.valueOf(HttpServletResponse.SC_OK));
			status.put("message", "query timeline successfully");
			jsonObject.put("meta", status);
			jsonObject.put("data", articles);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (RuntimeException van) {
			// report error
			LoggerFactory.getLogger(TimeLine.class).error("fatal error:", van);
			status.put("code", String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
			status.put("message", "internal error: " + van.getMessage());
			jsonObject.put("meta", status);
			jsonObject.put("data", "_");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			// return error messages
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, van.toString());
		}
		response.setContentType("application/json"); // specific content type
		response.setCharacterEncoding("utf-8");
		try (ServletOutputStream out = response.getOutputStream()) { // standardize , normalize it's good! believe me =-=
			out.write(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
			out.flush();
			// out.close();
			// TWR don't need close :)
		}
	}
}
