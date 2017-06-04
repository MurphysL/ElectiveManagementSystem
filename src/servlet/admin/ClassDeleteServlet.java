package servlet.admin;

import dao.DetailClassDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除课程
 */
@WebServlet(name = "ClassDeleteServlet", value = "/servlet/admin/ClassDeleteServlet")
public class ClassDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        int clzno = Integer.parseInt(request.getParameter("clzno"));
        System.out.println(clzno);
        if(DetailClassDao.deleteDetailClass(clzno)){
            request.getRequestDispatcher("ClassManageServlet?page=1").forward(request, response);
        }else{
            request.getRequestDispatcher("../../jsp/admin/update_fail.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
