<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="sc" class="bean.sc.DetailSC" scope="session"/>
<jsp:useBean id="student" class="bean.stu.Student" scope="session"/>
<!DOCTYPE HTML>
<html>
<head>
    <title><%=sc.getCname()%>(<%=sc.getTname()%>)</title>
    <meta charset="utf-8" />
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="../../css/ems.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
</head>
<body>

<!-- Nav -->
<div id="main_bg">
    <nav>
        <div id="logo">
            <a href="../../servlet/MainServlet?page=1" >NUC选修管理系统</a>
        </div>
    </nav>
</div>
<%
    long[] terms = TimeUtil.getTermTimeStamp();
%>
<!-- Main -->
<section id="main">
    <div class="inner">
        <div class="image fit">
            <img src="../../img/pic1.jpg" />
        </div>
        <header>
            <h1><%=sc.getCname()%> ( no.<%=sc.getCno()%> )</h1>
            <p class="info">教师：<%=sc.getTname()%> ( no.<%=sc.getTno()%> )</p>
            <%
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date date = new Date(sc.getStart()*1000);
                String time = format.format(date);
                long now = System.currentTimeMillis()/ 1000;
            %>
            <p class="info">开课时间：<%=time%></p>
            <p class="info">开课地址：<%=sc.getAddress()%></p>
            <p class="info">学分：<%=sc.getCredit()%></p>
            <%
                if(sc.getStart() > terms[0] && sc.getStart()+ TimeUtil.A_WEEK*sc.getDuration() < now){
            %>
                    <p class="info">状态：进行中</p>
            <%
                }else{
            %>
                    <p class="info"><%=sc.getGrade()%></p>
                    <p class="info">状态：已结束</p>
            <%
                }
            %>

        </header>
    </div>
</section>

<!-- Footer -->
<footer></footer>

</body>
</html>
