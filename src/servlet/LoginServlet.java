package servlet;

import bean.admin.Admin;
import bean.sc.Choose;
import bean.sc.SC;
import bean.stu.Student;
import bean.teacher.Teacher;
import dao.AdminDao;
import dao.SCDao;
import dao.StudentDao;
import dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录 :
 * 学生、教师、管理员分流
 */
@WebServlet(name = "LoginServlet", value = "/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        int no = Integer.parseInt(request.getParameter("no"));
        String password = request.getParameter("password");

        switch (type){
            case "student":
                Student student = StudentDao.login(no, password);
                if(student != null){
                    request.getSession().setAttribute("student", student);
                    Choose choose = new Choose();
                    if(!SCDao.queryThisTerm(student.getSno())){ // 本学期是否已选课
                        choose.setChoose(false);
                        request.getSession().setAttribute("choose", choose);
                        response.sendRedirect("stu/StudentMainServlet?page=1");
                    }else{
                        choose.setChoose(true);
                        request.getSession().setAttribute("choose", choose);
                        response.sendRedirect("stu/StudentInfoServlet?page=1");
                    }
                }else{
                    response.sendRedirect("../jsp/view/login_fail.jsp"); // 登录失败
                }
                break;
            case "teacher":
                Teacher teacher = TeacherDao.login(no, password); // 教师个人信息
                if(teacher != null){
                    System.out.println(teacher.toString());

                    request.getSession().setAttribute("teacher", teacher);
                    response.sendRedirect("teacher/TeacherInfoServlet?page=1");
                }else{
                    response.sendRedirect("../jsp/view/login_fail.jsp"); // 登录失败
                }
                break;
            case "admin":
                Admin admin = AdminDao.login(no, password);
                if(admin != null){
                    request.getSession().setAttribute("admin", admin);
                    request.getRequestDispatcher("../jsp/admin/admin_main.jsp").forward(request, response);
                }else{
                    response.sendRedirect("../jsp/view/login_fail.jsp"); // 登录失败
                }
                break;
            default:
                response.sendRedirect("../jsp/view/login_fail.jsp"); // 登录失败
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
