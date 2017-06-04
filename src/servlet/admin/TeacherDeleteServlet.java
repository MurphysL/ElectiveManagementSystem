package servlet.admin;

import dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2017/6/2.
 */
@WebServlet(name = "TeacherDeleteServlet", value = "/servlet/admin/TeacherDeleteServlet")
public class TeacherDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int tno = Integer.parseInt(request.getParameter("tno"));

        if(TeacherDao.deleteTeacher(tno)){
            request.getRequestDispatcher("TeacherManageServlet?page=1").forward(request, response);
        }else{
            request.getRequestDispatcher("../../jsp/view/update_fail.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
