package servlet.admin;

import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加学生信息
 */
@WebServlet(name = "StudentInsertServlet", value = "/servlet/admin/StudentInsertServlet")
public class StudentInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int sno = Integer.parseInt(request.getParameter("sno"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String dept = request.getParameter("dept");
        String password = request.getParameter("password");

        if(StudentDao.insertStudent(sno, name, sex, dept, password)){
            response.sendRedirect("/servlet/admin/StudentManageServlet");
        }else{
            response.sendRedirect("../../jsp/admin/insert_fail.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
