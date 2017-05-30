package servlet;

import bean.Sc;
import bean.ScWrapper;
import dao.SCDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 学生退课 Servlet
 */
@Deprecated
@WebServlet(name = "DeleteClassServlet", value = "/servlet/DeleteClassServlet")
public class DeleteClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int cno = Integer.parseInt(request.getParameter("cno"));
        int tno = Integer.parseInt(request.getParameter("tno"));
        int sno = Integer.parseInt(request.getParameter("sno"));

        System.out.println(cno + " " + tno+" " + sno +"=======");
        int result = SCDao.deleteClass(sno);
        System.out.println(result + "=======");
        if(result > 0){
            Sc sc = SCDao.queryThisTerm(sno);
            ScWrapper wrapper = new ScWrapper();
            wrapper.setNull(false);
            wrapper.setSc(sc);
            request.getSession().setAttribute("sc", wrapper);
            response.sendRedirect("/jsp/view/update_success.jsp");
        }else{
            response.sendRedirect("/jsp/view/fail.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
