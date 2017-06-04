package servlet.admin;

import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除学生信息
 */
@WebServlet(name = "StudentDeleteServlet", value = "/servlet/admin/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int sno = Integer.parseInt(request.getParameter("sno"));

        if(StudentDao.deleteStudent(sno)){
            request.getRequestDispatcher("StudentManageServlet?page=1").forward(request, response);
        }else{
            request.getRequestDispatcher("../jsp/view/update_fail.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
