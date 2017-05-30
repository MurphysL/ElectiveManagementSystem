package servlet;

import bean.DetailScs;
import bean.clz.DetailClass;
import dao.DetailClassDao;
import dao.SCDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 教师课程详细 Servlet
 */
@WebServlet(name = "TeacherClassDetailServlet", value = "/servlet/TeacherClassDetailServlet")
public class TeacherClassDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cno = Integer.parseInt(request.getParameter("cno"));
        int tno = Integer.parseInt(request.getParameter("tno"));
        long time = Integer.parseInt(request.getParameter("time"));

        DetailClass clz = DetailClassDao.queryDetailClass(cno, tno);
        request.getSession().setAttribute("clz", clz);
        DetailScs scs = SCDao.quertSelectScs(cno, tno, time);
        for(int i = 0 ;i < scs.getList().size() ;i ++){
            System.out.println(scs.getList().get(i).toString());
        }
        request.getSession().setAttribute("scs", scs);

        response.sendRedirect("/jsp/view/teacher_clz.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
