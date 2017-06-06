package servlet.admin;

import dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加教师信息
 */
@WebServlet(name = "TeacherInsertServlet", value = "/servlet/admin/TeacherInsertServlet")
public class TeacherInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String password = request.getParameter("password");

        if(TeacherDao.insertTeacher(name, sex, password)){
            response.sendRedirect("TeacherManageServlet?page=1");
        }else{
            response.sendRedirect("../../jsp/admin/insert_fail.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
