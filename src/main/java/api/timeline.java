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
 * �Լ���HttpServlet��do+�ַ��� ���ǻᱻ������������ͣ�����ʵ����doGet�ͻᴦ��GET��ʵ����doPost�ͻᴦ��POST����
 *
 * @author Eldath
 */
public class timeline extends HttpServlet {
    public timeline() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ���ܲ���
        String key = request.getParameter("keywords");
        // ҵ���߼�
        // ��������
        response.setCharacterEncoding("utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        out.print("Welcome to Lifeba");
        out.flush();
        out.close();
    }
}