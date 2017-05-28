<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/4/11
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Random" %>
<%@ page import="bean.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="courses" class="bean.Courses" scope="session"/>
<html>
<head>
    <meta charset="utf-8">
    <title>NUC选修管理系统</title>
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="../../css/yq.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <script src="../../js/yq.js" type="text/javascript"> </script>
</head>
<body>

<div id="main_bg">
    <!-- Header -->
    <header>
        <%@include file="../widght/nav_login.jsp" %>
        <%@include file="../widght/banner.jsp"%>
    </header>
    <!-- Content -->
    <div id="yq_content">
        <div id="yq_inner">
            <%
                for(int i = 1 ;i <= 4 ;i ++){
                    String div_id = "yq_frg" + i;
                    String img_id = "f_img" + i;
                    String a_id = "f_title" + i;
                    String p_id = "f_des" + i;
                    if(i-1 < courses.getCourses().size()){
                        Course course = courses.getCourses().get(i-1);
                        String cname = course.getCname();
            %>
                        <div id=<%=div_id%>>
                            <img src="../../img/pic1.jpg" id=<%=img_id%>>
                            <a id=<%=a_id%> class="title" href="../../servlet/BlogServlet?blog_id=<%=course.getCno()%>"><%=cname%></a>
                            <%--<p id=<%=p_id%> class="des"><%=main%></p>--%>
                        </div>
            <%
                    }else{
            %>
                        <div id=<%=div_id%>></div>
            <%
                    }
                }
            %>
        </div>
    </div>
    <!-- Bar -->
    <%@include file="../widght/bar.jsp"%>
</div>

</body>
</html>
