package servlet.admin;

import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 学生信息更新
 */
@WebServlet(name = "StudentUpdateServlet", value = "/servlet/admin/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int sno = Integer.parseInt(request.getParameter("sno"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String dept = request.getParameter("dept");
        String password = request.getParameter("password");
        String avatar = request.getParameter("avatar");

        if(StudentDao.updateStudent(sno, name, sex, dept, password, avatar)){
            request.getRequestDispatcher("StudentManageServlet?page=1").forward(request, response);
        }else{
            request.getRequestDispatcher("../../jsp/view/update_fail.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
