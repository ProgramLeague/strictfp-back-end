package api;

import db.MySqlAdapter;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.time.LocalDate;
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
			@NotNull HttpServletResponse response)
			throws ServletException, IOException {
		// 接受参数ܲ
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		JSONObject jsonObject = new JSONObject();
		HashMap<String, String> status = new HashMap<>();
		Vector<Article> articles = new Vector<>();
		status.put("code", String.valueOf(HttpServletResponse.SC_OK));
		status.put("message", "query timeline successfully");
		jsonObject.put("meta", status);
		for (int nowDate = start; nowDate <= end; nowDate++)
			articles.add(DatabaseOperator.getArticle(nowDate));
		jsonObject.put("data", articles);
		// 业务逻辑
		// 返回内容
		try (ServletOutputStream out = response.getOutputStream()) {
			out.write(jsonObject.toString().getBytes());
			out.flush();
		}
		response.setCharacterEncoding("utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
	}
}
