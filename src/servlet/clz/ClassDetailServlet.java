package servlet.clz;

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
@WebServlet(name = "ClassDetailServlet", value = "/servlet/clz/ClassDetailServlet")
public class ClassDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int clzno = Integer.parseInt(request.getParameter("clzno"));

        DetailClass clz = DetailClassDao.queryDetailClass(clzno);
        request.getSession().setAttribute("clz", clz);
        DetailSCList scs = DetailSCDao.quertSelectScs(clzno);
        request.getSession().setAttribute("scs", scs);

        response.sendRedirect("../../../jsp/view/teacher_clz.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
