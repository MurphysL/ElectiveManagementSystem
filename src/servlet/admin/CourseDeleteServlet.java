package servlet.admin;

import dao.CourseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除科目
 */
@WebServlet(name = "CourseDeleteServlet", value = "/servlet/admin/CourseDeleteServlet")
public class CourseDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        int cno = Integer.parseInt(request.getParameter("cno"));
        if(CourseDao.deleteCourse(cno)){
            request.getRequestDispatcher("CourseManageServlet?page=1").forward(request, response);
        }else{
            request.getRequestDispatcher("../../jsp/admin/update_fail.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
