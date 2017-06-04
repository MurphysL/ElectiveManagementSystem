package servlet.admin;

import bean.stu.StudentList;
import config.Config;
import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 学生信息管理
 */
@WebServlet(name = "StudentManageServlet", value = "/servlet/admin/StudentManageServlet")
public class StudentManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int page = Integer.parseInt(request.getParameter("page"));
        StudentList students = StudentDao.queryPagingStudent(page);

        int num = StudentDao.queryStudentCount();

        int pages;//总页数
        StringBuilder sb = new StringBuilder();
        if(num % Config.ADMIN_PAGE_NUM == 0){
            pages = num / Config.ADMIN_PAGE_NUM;
        }else{
            pages = num / Config.ADMIN_PAGE_NUM + 1;
        }
        for(int i = 1 ;i <= pages ;i ++){
            if(i == page){
                sb.append("<a href=../../servlet/admin/StudentManageServlet?page=")
                        .append(i)
                        .append(" id=\"select\" style=\"")
                        .append(Config.CSS_SELECT)
                        .append("\">")
                        .append(i)
                        .append("</a>");
            }else{
                sb.append("<a href=../../servlet/admin/StudentManageServlet?page=")
                        .append(i)
                        .append(" id=\"select\" style=\"")
                        .append(Config.CSS_UNSELECT)
                        .append("\">")
                        .append(i)
                        .append("</a>");
            }
        }
        request.getSession().setAttribute("bar", sb.toString());
        request.getSession().setAttribute("students", students);
        response.sendRedirect("../../jsp/admin/student_manage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
