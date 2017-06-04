<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="util.TimeUtil" %>
<%@ page import="bean.sc.DetailSc" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="scs" class="bean.sc.DetailSCList" scope="session"/>
<jsp:useBean id="clz" class="bean.clz.DetailClass" scope="session"/>
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
            <a href="../../servlet/MainServlet?page=1" >NUC选修管理系统</a>
        </div>
    </nav>
</div>

<!-- Main -->
<section id="main">
    <div class="inner">
        <header>
            <h1><%=clz.getCname()%> ( no.<%=clz.getCno()%> )</h1>
            <p class="info">教师：<%=clz.getTname()%> ( no.<%=clz.getTno()%> )</p>
            <%
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date date = new Date(clz.getStart()*1000);
                String time = format.format(date);
            %>
            <p class="info">开课时间：<%=time%></p>
            <p class="info">开课地址：<%=clz.getAddress()%></p>
            <p class="info">学分：<%=clz.getCredit()%></p>
            <%
                long[] terms = TimeUtil.getTermTimeStamp();
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

            <table  align="center" border="2" width="1000px" height="50px">
                <tr>
                    <td align="center">姓 名(学 号)</td>
                    <td align="center">性  别</td>
                    <td align="center">院  系</td>
                    <td align="center">成  绩</td>
                </tr>
                <%
                    List<DetailSc> sc = scs.getList();
                    for(int i = 0 ;i < sc.size() ;i ++){
                %>
                <tr>
                    <td align="center"><%=sc.get(i).getSname()%>(<%=sc.get(i).getSno()%>)</td>
                    <td align="center"><%=sc.get(i).getSsex()%></td>
                    <td align="center"><%=sc.get(i).getDept()%></td>
                    <td align="center"><%=sc.get(i).getGrade()%></td>
                </tr>
                <%
                    }
                %>
            </table>

        </header>
    </div>
</section>

<!-- Footer -->
<%@include file="../widght/footer.jsp"%>
</html>
