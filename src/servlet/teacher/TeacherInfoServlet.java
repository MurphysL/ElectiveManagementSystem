package servlet.teacher;

import bean.teacher.Teacher;
import bean.clz.DetailClassList;
import config.Config;
import dao.DetailClassDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 教师个人信息管理
 */
@WebServlet(name = "TeacherInfoServlet", value = "/servlet/teacher/TeacherInfoServlet")
public class TeacherInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int page = Integer.parseInt(request.getParameter("page"));
        int tno = ((Teacher)request.getSession().getAttribute("teacher")).getTno();
        DetailClassList classes = DetailClassDao.queryPagingClass4Teacher(tno, page); /* 查询教授过的课程 */

        int num = DetailClassDao.getClzCount4Teacher(tno); /* 查询教授过的课程数目 */

        int pages;// 总页数
        StringBuilder sb = new StringBuilder();
        if(num % Config.PAGE_BLOG_NUM == 0){
            pages = num / Config.PAGE_BLOG_NUM;
        }else{
            pages = num / Config.PAGE_BLOG_NUM + 1;
        }
        /* 拼接导航栏 */
        for(int i = 1 ;i <= pages ;i ++){
            if(i == page){ /* 当前页面 */
                sb.append("<a href=../../servlet/teacher/TeacherInfoServlet?page=")
                        .append(i)
                        .append(" id=\"select\" style=\"")
                        .append(Config.CSS_SELECT) /* CSS 样式 */
                        .append("\">")
                        .append(i)
                        .append("</a>");
            }else{ /* 其他页面 */
                sb.append("<a href=../../servlet/teacher/TeacherInfoServlet?page=")
                        .append(i)
                        .append(" id=\"select\" style=\"")
                        .append(Config.CSS_UNSELECT) /* CSS 样式 */
                        .append("\">")
                        .append(i)
                        .append("</a>");
            }
        }
        request.getSession().setAttribute("bar", sb.toString());
        request.getSession().setAttribute("classes", classes);
        response.sendRedirect("/jsp/teacher/teacher_info.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
