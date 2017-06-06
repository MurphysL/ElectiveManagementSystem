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
            <a href="../../servlet/stu/StudentInfoServlet?page=1" >中北大学选修管理系统</a>
        </div>
        <%
            /* 将数据库中时间类型（long） 转为字符串型时间*/
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = new Date(sc.getStart());
            String time = format.format(date);
                /* 获取当前时间 */
            long now = System.currentTimeMillis();
            long[] terms = TimeUtil.getTermTimeStamp(); /* 当前所在学期起始时间（term[0]）与终止时间 （term[1]）*/
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
            <h1><%=sc.getCname()%> ( no.<%=sc.getCno()%> )</h1>
            <p class="info">教师：<%=sc.getTname()%> ( no.<%=sc.getTno()%> )</p>
            <p class="info">开课时间：<%=time%></p>
            <p class="info">开课地址：<%=sc.getAddress()%></p>
            <p class="info">学分：<%=sc.getCredit()%></p>
            <%
                /* 开课时间晚于本学期开始时间, 并结课时间（开课时间 + 持续周数）晚于当前时间 */
                if(sc.getStart() > terms[0] && sc.getStart()+ TimeUtil.A_WEEK*sc.getDuration() > now){
            %>
                    <p class="info">状态：进行中</p>
            <%
                }else{
            %>
                    <p class="info">成绩：<%=sc.getGrade()%></p>
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
