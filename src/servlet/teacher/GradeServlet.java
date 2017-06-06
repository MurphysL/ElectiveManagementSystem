package servlet.teacher;

import bean.sc.DetailSCList;
import dao.SCDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 成绩录入
 */
@WebServlet(name = "GradeServlet", value = "/servlet/teacher/GradeServlet")
public class GradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        DetailSCList scs = (DetailSCList) request.getSession().getAttribute("scs");

        int clzno = Integer.parseInt(request.getParameter("clzno"));
        for(int i = 0 ;i < scs.getList().size() ;i ++){ /* 选课人数 */
            int sno = Integer.parseInt(request.getParameter("no" + i));
            int grade = Integer.parseInt(request.getParameter("grade" + i));
            if(!SCDao.updateGrade(clzno, sno, grade))
                request.getRequestDispatcher("../../jsp/teacher/update_fail.jsp").forward(request, response); /* 更新失败 报错*/
        }
        request.getRequestDispatcher("../../jsp/teacher/update_success.jsp").forward(request, response); /* 更新成功*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
