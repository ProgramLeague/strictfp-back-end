package api;

import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class Test extends HttpServlet {
	public Test(){}

	@Override
	protected void doGet(
			@NotNull HttpServletRequest req,
			@NotNull HttpServletResponse resp
	) throws ServletException, IOException {
		ServletOutputStream sos=resp.getOutputStream();
		resp.setContentType("text/plain");
		sos.println("bibibi");
		sos.flush();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ignored) {
		}
		sos.println("bobobo");
		sos.flush();
		sos.close();
	}
}
