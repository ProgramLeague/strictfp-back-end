import api.TimeLine;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by Eldath on 2017/1/17 0017.
 * <p>
 * 实现了一个API，就要在下面那里加上。
 *
 * @author Eldath
 */
public class MainServer {
	public static void main(String[] args) throws Exception {
		Server server = new Server(80);
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/api/v0");
		server.setHandler(context);
		// 像下面这行一样
		context.addServlet(new ServletHolder(new TimeLine()), "/timeline");
		server.start();
		server.join();
	}
}
