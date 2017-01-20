package api;

import db.DatabaseOperator;
import db.obj.Article;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
		// 接受参数ܲ
		response.setCharacterEncoding("utf-8");
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		JSONObject jsonObject = new JSONObject();
		Vector<Article> articles = new Vector<>();
		Map<String, String> status = new HashMap<>();
		// 业务逻辑
		try {
			// database operations
			for (int nowDate = start; nowDate <= end; ++nowDate)
				articles.add(DatabaseOperator.getArticle(nowDate));
			jsonObject.put("data", articles);
			status.put("code", String.valueOf(HttpServletResponse.SC_OK));
			status.put("message", "query timeline successfully");
			jsonObject.put("meta", status);
			// 返回内容
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (RuntimeException van) {
			LoggerFactory.getLogger(TimeLine.class).error("fatal error:", van);
			status.put("code", String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
			status.put("message", "internal error: " + van.getMessage());
			jsonObject.put("meta", status);
			jsonObject.put("data", "_");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			// return error messages
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, van.toString());
		}
		try (PrintWriter pw = response.getWriter()) {
			pw.write(jsonObject.toString());
			pw.flush();
		}
	}
}
