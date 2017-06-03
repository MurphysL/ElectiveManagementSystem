package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2017/6/3.
 */
@WebServlet(name = "ClassUpdateServlet")
public class ClassUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int cno = Integer.parseInt(request.getParameter("cno"));
        String cname = request.getParameter("cname");
        int credit = Integer.parseInt(request.getParameter("credit"));
        int tno = Integer.parseInt(request.getParameter("tno"));
        String tname = request.getParameter("tname");
        String tsex = request.getParameter("tsex");
        String address = request.getParameter("address");
        Long time = Long.parseLong(request.getParameter("time"));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
