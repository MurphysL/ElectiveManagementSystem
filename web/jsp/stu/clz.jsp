<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="clz" class="bean.clz.DetailClass" scope="session"/>
<jsp:useBean id="student" class="bean.stu.Student" scope="session"/>
<!DOCTYPE HTML>
<html>
<head>
    <title><%=clz.getCname()%>(<%=clz.getTname()%>)</title>
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
            <a href="../../servlet/stu/StudentMainServlet?page=1" >NUC选修管理系统</a>
        </div>
        <%
            long[] terms = TimeUtil.getTermTimeStamp();
            long now = System.currentTimeMillis()/ 1000;
            if(clz.getStart() > terms[0] && clz.getStart()+ TimeUtil.A_WEEK*clz.getDuration() < now){
        %>
            <ul>
                <li><a href="../../servlet/stu/SelectClassServlet?clzno=<%=clz.getClzno()%>&sno=<%=student.getSno()%>">选课</a></li>
            </ul>
        <%
            }
        %>

    </nav>
</div>

<!-- Main -->
<section id="main">
    <div class="inner">
        <div class="image fit">
            <img src="../../img/pic1.jpg" />
        </div>
        <header>
            <h1><%=clz.getCname()%> ( no.<%=clz.getCno()%> )</h1>
            <p class="info">教师：<%=clz.getTname()%> ( no.<%=clz.getTno()%> )</p>
            <%
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date date = new Date(clz.getStart()*1000);
                String time = format.format(date);
            %>
            <p class="info">开课时间：<%=time%></p>
            <p class="info">周数：<%=clz.getDuration()%> 周</p>
            <p class="info">开课地址：<%=clz.getAddress()%></p>
            <p class="info">学分：<%=clz.getCredit()%></p>
            <%
                if(clz.getStart() > terms[0] && clz.getStart() < terms[1]){
            %>
                    <p class="info">状态：进行中</p>
            <%
                }else{
            %>
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
