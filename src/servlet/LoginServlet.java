package servlet;

import bean.Sc;
import bean.ScWrapper;
import bean.Student;
import dao.SCDao;
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
        switch (type){
            case "student":
                Student student = StudentDao.login(no, password);
                if(student != null){
                    System.out.println(student.toString());
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
