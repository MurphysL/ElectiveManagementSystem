package servlet.stu;

import bean.stu.Student;
import bean.teacher.Teacher;
import dao.StudentDao;
import dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 教师信息更改
 */
@WebServlet(name = "StudentUpdateInfoServlet", value = "/servlet/stu/StudentUpdateInfoServlet")
public class StudentUpdateInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int sno = Integer.parseInt(request.getParameter("sno"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String dept = request.getParameter("dept");
        String password = request.getParameter("password");
        String avatar = request.getParameter("avatar");

        if(StudentDao.updateStudent(sno, name, sex, dept, password, avatar)){
            Student student = StudentDao.queryStudentById(sno);
            request.getSession().setAttribute("student", student);
            request.getRequestDispatcher("StudentInfoServlet?page=1").forward(request, response);
        }else{
            request.getRequestDispatcher("../jsp/view/update_fail.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
