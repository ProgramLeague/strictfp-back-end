package main;

import api.Test;
import api.TimeLine;
import api.User;
import api.auth.CheckCert;
import api.misc.Heartbeat;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Eldath on 2017/1/17 0017.
 * <p>
 * 实现了一个API，就要在下面那里加上。
 *
 * @author Eldath
 */
@SuppressWarnings("WeakerAccess")
public class MainServer {
	public static void main(@NotNull @NonNls String[] args) throws Exception {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\log4j.properties");
		Server server = new Server(233);
		ServletContextHandler context =
				new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/api/v0");
		server.setHandler(context);
		server.setStopAtShutdown(true);
		// 像下面这行一样
		context.addServlet(
				new ServletHolder(new TimeLine()),
				"/timeline"
		);
		context.addServlet(
				new ServletHolder(new User()),
				"/user"
		);
		context.addServlet(
				new ServletHolder(new Heartbeat()),
				"/misc/heartbeat"
		);
		context.addServlet(
				new ServletHolder(new Test()),
				"/test"
		);
		context.addServlet(
				new ServletHolder(new CheckCert()),
				"/auth/check_cert"
		);
		server.start();
		server.join();
	}
}
