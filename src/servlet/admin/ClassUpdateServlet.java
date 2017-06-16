package servlet.admin;

import dao.ClassDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 课程信息更改
 */
@WebServlet(name = "ClassUpdateServlet", value = "/servlet/admin/ClassUpdateServlet")
public class ClassUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        int clzno = Integer.parseInt(request.getParameter("clzno"));
        int cno = Integer.parseInt(request.getParameter("cno"));
        String start = request.getParameter("start");
        String address = request.getParameter("address");
        int tno = Integer.parseInt(request.getParameter("tno"));

        if(ClassDao.updateClz(clzno, cno, tno, start, address)){
            request.getRequestDispatcher("ClassManageServlet?page=1").forward(request, response);
        }else{
            request.getRequestDispatcher("../../jsp/admin/update_fail.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
