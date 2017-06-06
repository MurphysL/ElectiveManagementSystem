package servlet.admin;

import dao.CourseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加科目
 */
@WebServlet(name = "CourseInsertServlet", value = "/servlet/admin/CourseInsertServlet")
public class CourseInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        int credit = Integer.parseInt(request.getParameter("credit"));
        int duration = Integer.parseInt(request.getParameter("duration"));
        if(CourseDao.insertCourse(name, credit, duration)){
            response.sendRedirect("CourseManageServlet?page=1");
        }else{
            response.sendRedirect("../../jsp/admin/insert_fail.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
