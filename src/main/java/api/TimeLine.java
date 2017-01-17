package api;

import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
		String key = request.getParameter("keywords");
		// 业务逻辑
		// 返回内容
		response.setCharacterEncoding("utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		PrintWriter out = response.getWriter();
		out.print("Welcome to Lifeba");
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(
			@NotNull HttpServletRequest req,
			@NotNull HttpServletResponse resp)
			throws ServletException, IOException {
	}
}