package servlet;

import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2017/6/2.
 */
@WebServlet(name = "StudentUpdateServlet", value = "/servlet/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int sno = Integer.parseInt(request.getParameter("sno"));
        String sname = request.getParameter("sname");
        String ssex = request.getParameter("ssex");
        String sdept = request.getParameter("sdept");
        String password = request.getParameter("password");

        if(StudentDao.updateStudent(sno, sname, ssex, sdept, password)){
            request.getRequestDispatcher("StudentManageServlet?page=1").forward(request, response);
        }else{
            request.getRequestDispatcher("../jsp/view/update_fail.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
