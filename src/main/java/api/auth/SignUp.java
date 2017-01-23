package api.auth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Eldath on 2017/1/22 0022.
 *
 * @author Eldath
 */
public class SignUp extends HttpServlet {
	public SignUp(){}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Expires", "Tue, 17 Aug 1926 08:00:00");
		resp.setHeader("Pragma", "no-cache");
		super.doPost(req, resp);
	}
}
