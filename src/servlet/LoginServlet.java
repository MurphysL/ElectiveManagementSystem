package servlet;

import bean.*;
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

                    Sc sc = SCDao.queryThisTerm(student.getSno());
                    ScWrapper wrapper = new ScWrapper();
                    wrapper.setSc(sc);
                    if(sc == null){
                        wrapper.setNull(true);
                        request.getSession().setAttribute("sc", wrapper);
                        response.sendRedirect("StudentMainServlet?page=1");
                    }else{
                        wrapper.setNull(false);
                        request.getSession().setAttribute("sc", wrapper);
                        response.sendRedirect("SelfMainServlet?page=1");
                    }
                }
                break;
            case "teacher":
                Teacher teacher = TeacherDao.login(no, password); // 教师个人信息
                if(teacher != null){
                    request.getSession().setAttribute("teacher", teacher);
                    response.sendRedirect("TeacherSelfServlet?page=1");
                }
                break;
            case "admin":
                Admin admin = AdminDao.login(no, password);
                if(admin != null){
                    request.getSession().setAttribute("admin", admin);
                    request.getRequestDispatcher("../jsp/view/admin_main.jsp").forward(request, response);
                }
                break;
            default:
                break;
        }
        // 登录失败
        response.sendRedirect("../jsp/view/login_fail.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
