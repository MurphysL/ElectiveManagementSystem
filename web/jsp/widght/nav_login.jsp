<%@ page import="bean.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <div id="logo">
        <a href="../../servlet/StudentMainServlet?page=1" >NUC选修管理系统</a>
    </div>
    <div id="avatar">
        <a href="../../servlet/SelfMainServlet?page=1">
            <img src=<%=((Student)request.getSession().getAttribute("student")).getAvatar()%>>
        </a>
    </div>
</nav>
