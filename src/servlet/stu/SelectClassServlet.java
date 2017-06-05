package servlet.stu;

import bean.sc.Choose;
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
@WebServlet(name = "SelectClassServlet", value = "/servlet/stu/SelectClassServlet")
public class SelectClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clzno = Integer.parseInt(request.getParameter("clzno"));
        int sno = Integer.parseInt(request.getParameter("sno"));

        if(SCDao.insertClass(clzno, sno)){
            Choose choose = new Choose();
            choose.setChoose(true);
            request.getSession().setAttribute("choose", choose);
            response.sendRedirect("../../jsp/view/update_success.jsp");
        }else{
            //选课失败
            response.sendRedirect("../../jsp/stu/delete_fail.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
