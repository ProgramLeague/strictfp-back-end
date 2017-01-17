package api;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Eldath on 2017/1/17 0017.
 * <p>
 * 自己看HttpServlet，do+字符串 就是会被处理的请求类型（例如实现了doGet就会处理GET，实现了doPost就会处理POST）。
 *
 * @author Eldath
 */
public class timeline extends HttpServlet {
    public timeline() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 接受参数
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
}