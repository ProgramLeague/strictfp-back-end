package api;

import db.DatabaseOperator;
import db.obj.Article;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import test.tool.Constant;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
			@NotNull HttpServletResponse response
	) throws IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		LocalDate start = LocalDate.parse(request.getParameter("start"));
		LocalDate end = LocalDate.parse(request.getParameter("end"));
		JSONObject json = new JSONObject();
		Vector<Article> articles = new Vector<>();
		Map<String, Object> status = new HashMap<>();
		try {
			// get info
			for (LocalDate nowDate = start;
			     nowDate.isBefore(end) || nowDate.isEqual(end);
			     nowDate = nowDate.plusDays(1)) {
				Article nowArticle = DatabaseOperator.getArticle(nowDate);
				if (nowArticle == null) break;
				articles.add(nowArticle);
			}
			if (articles.isEmpty()) throw new RuntimeException("no article now");
			// build status
			status.put("code", String.valueOf(HttpServletResponse.SC_OK));
			status.put("message", "query timeline successfully");
			status.put("extra", Constant.JSON.EMPTY_OBJECT);
			status.put("security", Constant.JSON.EMPTY_OBJECT);
			json.put("meta", status);
			json.put("data", articles);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (RuntimeException van) {
			// report error
			LoggerFactory.getLogger(TimeLine.class).error("fatal error:", van);
			status.put("code", String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR + ".0"));
			status.put("message", "internal error: " + van.getMessage());
			status.put("extra", Constant.JSON.EMPTY_OBJECT);
			status.put("security", Constant.JSON.EMPTY_OBJECT);
			json.put("meta", status);
			json.put("data", "_");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			// return error messages
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, van.toString());
		}
		// FIXME 非测试时移去注释
		// response.setContentType("application/json"); // specific content type
		try (ServletOutputStream out = response.getOutputStream()) { // standardize , normalize it's good! believe me =-=
			out.write(json.toString().getBytes(StandardCharsets.UTF_8));
			out.flush();
			// out.close();
			// TWR don't need close :)
		}
	}
}
