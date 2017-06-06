package servlet.stu;

import bean.sc.DetailSC;
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
@WebServlet(name = "SCDetailServlet", value = "/servlet/stu/SCDetailServlet")
public class SCDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int clzno = Integer.parseInt(request.getParameter("clzno"));
        int sno = Integer.parseInt(request.getParameter("sno"));

        DetailSC sc = DetailSCDao.queryDetailSC(clzno, sno); /* 查询选课详细信息 */
        request.getSession().setAttribute("sc", sc);

        response.sendRedirect("../../jsp/stu/sc.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
