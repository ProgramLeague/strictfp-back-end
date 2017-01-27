package main;

import api.TimeLine;
import api.User;
import api.auth.CheckCert;
import api.misc.Counter;
import api.misc.GetQuiz;
import api.misc.Heartbeat;
import api.misc.SafeCheck;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tool.Constant;

/**
 * Created by Eldath on 2017/1/17 0017.
 * <p>
 * 实现了一个API，就要在下面那里加上。
 *
 * @author Eldath
 */
@SuppressWarnings("WeakerAccess")
public class MainServer {
	private static Logger logger = LoggerFactory.getLogger(MainServer.class);

	public static void main(@NotNull @NonNls String[] args) throws Exception {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");
		logger.warn("StrictFP | Back-end");
		logger.info("StrictFP Back-end is now running...");
		Server server = new Server(Constant.SERVER.SERVER_PORT);
		ServletContextHandler context =
				new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/api/v0");
		server.setHandler(context);
		server.setStopAtShutdown(true);
		// 像下面这行一样
		context.addServlet(new ServletHolder(new GetQuiz()), "/misc/getquiz");
		context.addServlet(new ServletHolder(new TimeLine()), "/timeline");
		context.addServlet(new ServletHolder(new Counter()), "/misc/counter");
		context.addServlet(new ServletHolder(new User()), "/user");
		context.addServlet(new ServletHolder(new Heartbeat()), "/misc/heartbeat");
		context.addServlet(new ServletHolder(new SafeCheck()), "/misc/safecheck");
		context.addServlet(new ServletHolder(new CheckCert()), "/auth/check_cert");
		//
		server.start();
		server.join();
	}
}
