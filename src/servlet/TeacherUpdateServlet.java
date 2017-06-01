package servlet;

import dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2017/6/1.
 */
@WebServlet(name = "TeacherUpdateServlet", value = "/servlet/TeacherUpdateServlet")
public class TeacherUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int tno = Integer.parseInt(request.getParameter("tno"));
        String tname = request.getParameter("tname");
        String tsex = request.getParameter("tsex");
        String password = request.getParameter("password");

        if(TeacherDao.updateTeacher(tno, tname, tsex, password)){
            request.getRequestDispatcher("TeacherManageServlet?page=1").forward(request, response);
        }else{
            request.getRequestDispatcher("../jsp/view/update_fail.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
