package api.misc;

import db.DatabaseOperator;
import db.obj.Article;
import db.obj.Pair;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import tool.Tools;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
		int counterId = Tools.getValidNumber(req.getParameter("counterid"));
		boolean operation = "+1s".equals(req.getParameter("op"));
		Map<String, String> status = new HashMap<>();
		if ("WR".equals(action)) {
			DatabaseOperator.plus1s(counterId, operation);
			resp.setStatus(HttpServletResponse.SC_OK);
			// finished!
		} else if ("RD".equals(action)) {
			Article article = DatabaseOperator.getArticle(new Pair("Id", "=" + counterId));
			// response
			if (article == null) {
				// return error message: article not found!
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			} else {
				// return up or down
				// operation ? article.getUp() : article.getDown();
				resp.setStatus(HttpServletResponse.SC_OK);
			}
		}
	}

	@Contract(pure = true)
	private int doReadCounter() {
		return 0;
	}
}
