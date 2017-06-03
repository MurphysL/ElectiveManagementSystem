package servlet;

import bean.clz.DetailClasses;
import config.Config;
import dao.DetailClassDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2017/6/3.
 */
@WebServlet(name = "ClassManageServlet", value = "/servlet/ClassManageServlet")
public class ClassManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Integer page = Integer.parseInt(request.getParameter("page"));
        DetailClasses classes = DetailClassDao.queryPagingDetailClasses(page);
        int num = classes.getNum();

        int pages;//总页数
        StringBuilder sb = new StringBuilder();
        if(num % Config.ADMIN_PAGE_NUM == 0){
            pages = num / Config.ADMIN_PAGE_NUM;
        }else{
            pages = num / Config.ADMIN_PAGE_NUM + 1;
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
                sb.append("<a href=../../servlet/ClassManageServlet?page=")
                        .append(i)
                        .append(" id=\"select\" style=\"")
                        .append(select_css)
                        .append("\">")
                        .append(i)
                        .append("</a>");
            }else{
                sb.append("<a href=../../servlet/ClassManageServlet?page=")
                        .append(i)
                        .append(" id=\"select\" style=\"")
                        .append(unselect_css)
                        .append("\">")
                        .append(i)
                        .append("</a>");
            }
        }

        request.getSession().setAttribute("bar", sb.toString());
        request.getSession().setAttribute("classes", classes);
        response.sendRedirect("../jsp/view/class_manage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
