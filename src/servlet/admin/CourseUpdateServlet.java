package servlet.admin;

import dao.CourseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 科目信息更改
 */
@WebServlet(name = "CourseUpdateServlet", value = "/servlet/admin/CourseUpdateServlet")
public class CourseUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        int cno = Integer.parseInt(request.getParameter("cno"));
        String name = request.getParameter("name");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int credit = Integer.parseInt(request.getParameter("credit"));

        if(CourseDao.updateCourse(cno, name, credit, duration)){
            request.getRequestDispatcher("CourseManageServlet?page=1").forward(request, response);
        }else{
            request.getRequestDispatcher("../../jsp/admin/update_fail.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
