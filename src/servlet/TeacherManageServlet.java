package servlet;

import bean.TeacherWrapper;
import config.Config;
import dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2017/6/1.
 */
@WebServlet(name = "TeacherManageServlet", value = "/servlet/TeacherManageServlet")
public class TeacherManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int page = Integer.parseInt(request.getParameter("page"));
        TeacherWrapper teahcers = TeacherDao.queryPagingTeachers(page);
        int num = teahcers.getNum();

        int pages;//总页数
        StringBuilder sb = new StringBuilder();
        if(num % Config.PAGE_BLOG_NUM == 0){
            pages = num / Config.PAGE_BLOG_NUM;
        }else{
            pages = num / Config.PAGE_BLOG_NUM + 1;
        }
        String unselect_css = "margin: 10px;\n" +
                "\tbackground-color: #040E17;\n" +
                "\ttext-decoration: none;\n" +
                "\tfont-size: 20px;\n" +
                "\tfont-weight: 900;\n" +
                "\tcolor: white;\n" +
                "\twidth: 30px;\n" +
                "\tline-height: 30px;\n" +
                "\tdisplay: inline-block;\n" +
                "\tborder-radius: 25px;";
        String select_css = "margin: 10px;\n" +
                "\tbackground-color: #FFA500;\n" +
                "\ttext-decoration: none;\n" +
                "\tfont-size: 20px;\n" +
                "\tfont-weight: 900;\n" +
                "\tletter-spacing: 1px;\n" +
                "\tcolor: white;\n" +
                "\twidth: 30px;\n" +
                "\tline-height: 30px;\n" +
                "\tdisplay: inline-block;\n" +
                "\tborder-radius: 25px;";
        for(int i = 1 ;i <= pages ;i ++){
            if(i == page){
                sb.append("<a href=../../servlet/TeacherManageServlet?page=")
                        .append(i)
                        .append(" id=\"select\" style=\"")
                        .append(select_css)
                        .append("\">")
                        .append(i)
                        .append("</a>");
            }else{
                sb.append("<a href=../../servlet/TeacherManageServlet?page=")
                        .append(i)
                        .append(" id=\"select\" style=\"")
                        .append(unselect_css)
                        .append("\">")
                        .append(i)
                        .append("</a>");
            }
        }
        request.getSession().setAttribute("bar", sb.toString());
        request.getSession().setAttribute("teachers", teahcers);
        response.sendRedirect("../jsp/view/teachers_manage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
