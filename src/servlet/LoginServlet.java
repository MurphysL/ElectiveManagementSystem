package servlet;

import bean.Student;
import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录 Servlet
 */
@WebServlet(name = "LoginServlet", value = "/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        int no = Integer.parseInt(request.getParameter("no"));
        String password = request.getParameter("password");
        System.out.println(no + " " + password + " " + type);
        switch (type){
            case "student":
                System.out.println("13232");
                Student student = StudentDao.login(no, password);
                if(student != null){
                    System.out.println(student.toString());
                    request.getSession().setAttribute("student", student);
                    response.sendRedirect("MainServlet?page=1");
                }else{
                    response.sendRedirect("../jsp/view/login_fail.jsp");
                }

                break;
            case "teacher":
                break;
            case "admin":
                break;
            default:
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
