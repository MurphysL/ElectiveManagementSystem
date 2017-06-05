package servlet.stu;

import bean.sc.DetailSCList;
import bean.stu.Student;
import config.Config;
import dao.DetailSCDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 学生信息管理
 */
@WebServlet(name = "StudentInfoServlet", value = "/servlet/stu/StudentInfoServlet")
public class StudentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int page = Integer.parseInt(request.getParameter("page"));
        Student student = (Student) request.getSession().getAttribute("student");
        System.out.println(student.toString());
        DetailSCList sc = DetailSCDao.querySelectedPagingDetailSC(student.getSno(), page);
        int num = DetailSCDao.getSelectedSCCount(student.getSno());

        int pages;//总页数
        StringBuilder sb = new StringBuilder();
        if(num % Config.PAGE_BLOG_NUM == 0){
            pages = num / Config.PAGE_BLOG_NUM;
        }else{
            pages = num / Config.PAGE_BLOG_NUM + 1;
        }
        for(int i = 1 ;i <= pages ;i ++){
            if(i == page){
                sb.append("<a href=../../servlet/StudentInfoServlet?page=")
                        .append(i)
                        .append(" id=\"select\" style=\"")
                        .append(Config.CSS_SELECT)
                        .append("\">")
                        .append(i)
                        .append("</a>");
            }else{
                sb.append("<a href=../../servlet/StudentInfoServlet?page=")
                        .append(i)
                        .append(" id=\"select\" style=\"")
                        .append(Config.CSS_UNSELECT)
                        .append("\">")
                        .append(i)
                        .append("</a>");
            }
        }
        request.getSession().setAttribute("bar", sb.toString());
        request.getSession().setAttribute("scs", sc);
        response.sendRedirect("/jsp/stu/student_info.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
