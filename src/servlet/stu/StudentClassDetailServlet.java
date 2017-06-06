package servlet.stu;

import bean.clz.DetailClass;
import bean.sc.DetailSCList;
import dao.DetailClassDao;
import dao.DetailSCDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 课程详细信息
 */
@WebServlet(name = "StudentClassDetailServlet", value = "/servlet/clz/StudentClassDetailServlet")
public class StudentClassDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int clzno = Integer.parseInt(request.getParameter("clzno"));

        DetailClass clz = DetailClassDao.queryDetailClass(clzno); /* 课程详细 */
        request.getSession().setAttribute("clz", clz);

        response.sendRedirect("../../jsp/stu/clz.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
