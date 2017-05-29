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
 * 选课
 */
@WebServlet(name = "SelectClassServlet", value = "/servlet/SelectClassServlet")
public class SelectClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cno = Integer.parseInt(request.getParameter("cno"));
        int tno = Integer.parseInt(request.getParameter("tno"));
        int sno = Integer.parseInt(request.getParameter("sno"));

        int result = SCDao.insertClass(cno, tno, sno);
        if(result > 0){
            Sc sc = SCDao.queryThisTerm(sno);
            ScWrapper wrapper = new ScWrapper();
            wrapper.setSc(sc);
            wrapper.setNull(false);
            request.getSession().setAttribute("sc", wrapper);
            response.sendRedirect("/jsp/view/update_success.jsp");
        }else{
            //选课失败
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
