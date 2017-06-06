package servlet.teacher;

import bean.teacher.Teacher;
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
@WebServlet(name = "TeacherUpdateInfoServlet", value = "/servlet/teacher/TeacherUpdateInfoServlet")
public class TeacherUpdateInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int tno = Integer.parseInt(request.getParameter("tno"));
        String tname = request.getParameter("tname");
        String tsex = request.getParameter("tsex");
        String password = request.getParameter("password");
        String avatar = request.getParameter("avatar");

        if(TeacherDao.updateTeacher(tno, tname, tsex, password, avatar)){
            Teacher teacher = TeacherDao.query(tno); /* 更新session中teacher的值*/
            request.getSession().setAttribute("teacher", teacher);
            request.getRequestDispatcher("../../jsp/teacher/update_success.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("../../jsp/teacher/update_fail.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
