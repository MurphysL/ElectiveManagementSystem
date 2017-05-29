package servlet;

import bean.clz.DetailClass;
import dao.DetailClassDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 课程详细 Servlet
 */
@WebServlet(name = "ClassDetailServlet",value = "/servlet/ClassDetailServlet")
public class ClassDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cno = Integer.parseInt(request.getParameter("cno"));
        int tno = Integer.parseInt(request.getParameter("tno"));

        DetailClass clz = DetailClassDao.queryDetailClass(cno, tno);
        System.out.println(cno+" "+tno+" " + clz.toString());
        request.getSession().setAttribute("clz", clz);
        response.sendRedirect("/jsp/view/clz.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
