<%@ page import="bean.clz.DetailClass" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="teacher" class="bean.Teacher" scope="session"/>
<jsp:useBean id="classes" class="bean.clz.DetailClasses" scope="session"/>
<html>
<head>
    <title>教师课程管理</title>
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="../../css/yq.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <script src="../../js/yq.js" type="text/javascript"> </script>
</head>
<body>

<div id="main_bg">
    <!-- Header -->
    <header>
        <nav>
            <div id="logo">
                <a href="../../servlet/TeacherSelfServlet?page=1" >NUC选修管理系统</a>
            </div>
            <%--<div id="avatar">
                <a href="../../servlet/SelfMainServlet?page=1">
                    <img src=<%=((Student)request.getSession().getAttribute("student")).getAvatar()%>>
                </a>
            </div>--%>
        </nav>
        <div id ="yq_banner">
            <div>
                <h1><%=teacher.getTname()%></h1>
                <h4 style="margin-top: 60px;color: white;align-items: center;text-align: center;">
                    <%=teacher.getTno()%>
                </h4>
                <h4 style="margin-top: 60px;color: white;align-items: center;text-align: center;">
                    <%=teacher.getTsex()%>
                </h4>
            </div>
        </div>
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
                    if(i-1 < classes.getList().size()){
                        DetailClass clz = classes.getList().get(i-1);
                        String cname = clz.getCname();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        Date date = new Date(clz.getTime()*1000);
                        String time = format.format(date);
            %>
            <div id=<%=div_id%>>
                <img src="../../img/pic1.jpg" id=<%=img_id%>>
                <a id=<%=a_id%> class="title"
                   href="../../servlet/TeacherClassDetailServlet?cno=<%=clz.getCno()%>&tno=<%=clz.getTno()%>&time=<%=clz.getTime()%>"><%=cname%></a>
                <p id=<%=p_id%> class="des"><%=time%></p>
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
