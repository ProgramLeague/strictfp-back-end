package api.misc;

import db.DatabaseOperator;
import db.obj.Article;
import db.obj.Pair;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import tool.Constant;
import tool.Tools;

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
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class Counter extends HttpServlet {
	@Override
	protected void doPost(
			@NotNull HttpServletRequest req,
			@NotNull HttpServletResponse resp
	) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		String counterPoolId = req.getParameter("counterpool");
		JSONObject response = new JSONObject();
		int counterId = Tools.getValidNumber(req.getParameter("counterid"));
		boolean operation = "up".equalsIgnoreCase(req.getParameter("op"));
		Map<String, Object> status = new HashMap<>();
		if ("WR".equals(action)) {
			DatabaseOperator.plus1s(counterId, operation);
			resp.setStatus(HttpServletResponse.SC_OK);
			status.put("code", String.valueOf(HttpServletResponse.SC_OK));
			status.put("message", "operation successful");
			response.put("meta", status);
			response.put("data", Constant.PADDING);
			// finished!
		} else if ("RD".equals(action)) {
			Article article = DatabaseOperator.getArticle(new Pair("Id", "=" + counterId));
			// response
			if (article == null) {
				status.put("code", String.valueOf(HttpServletResponse.SC_NOT_FOUND));
				status.put("message", "article not found");
				status.put("extra", Constant.JSON.EMPTY_OBJECT);
				status.put("security", Constant.JSON.EMPTY_OBJECT);
				response.put("meta", status);
				response.put("data", Constant.PADDING);
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			} else {
				status.put("code", String.valueOf(HttpServletResponse.SC_OK));
				status.put("message", "article found successfully");
				response.put("meta", status);
				JSONObject inter = new JSONObject();
				inter.put("value", operation ? article.getUp() : article.getDown());
				response.put("data", inter);
				resp.setStatus(HttpServletResponse.SC_OK);
			}
		}
		status.put("extra", Constant.JSON.EMPTY_OBJECT);
		status.put("security", Constant.JSON.EMPTY_OBJECT);
		// FIXME 非测试时移去注释 （配合Configuration System把这里设计的合理一点 - 磷）
		// response.setContentType("application/json"); // specific content type
		try (ServletOutputStream out = resp.getOutputStream()) {
			out.write(response.toString().getBytes(StandardCharsets.UTF_8));
			out.flush();
		} catch (IOException e) {
			LoggerFactory.getLogger(Counter.class).error("IOException thrown: ", e);
		}
	}
}
