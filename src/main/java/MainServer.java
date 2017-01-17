import api.timeline;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by Eldath on 2017/1/17 0017.
 *
 * ʵ����һ��API����Ҫ������������ϡ�
 * @author Eldath
 */
public class MainServer {
    public static void main(String[] args) {
        try {
            Server server = new Server(80);
            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/api/v0");
            server.setHandler(context);
            // ����������һ��
            context.addServlet(new ServletHolder(new timeline()), "/timeline");
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
