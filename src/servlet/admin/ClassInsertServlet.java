package servlet.admin;

import dao.ClassDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加课程
 */
@WebServlet(name = "ClassInsertServlet", value = "/servlet/admin/ClassInsertServlet")
public class ClassInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int cno = Integer.parseInt(request.getParameter("cno"));
        int tno = Integer.parseInt(request.getParameter("tno"));
        String start = request.getParameter("start");
        String address = request.getParameter("address");
        if(ClassDao.insertClz(cno, tno, start, address)){
            response.sendRedirect("ClassManageServlet?page=1");
        }else{
            response.sendRedirect("../../jsp/admin/insert_fail.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
