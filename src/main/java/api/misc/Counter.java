package api.misc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class Counter extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String counterPoolId = req.getParameter("counterpool");
		String counterId = req.getParameter("counterid");
		String operation = req.getParameter("op");
	}

	private int doReadCounter() {
		return 0;
	}
}
