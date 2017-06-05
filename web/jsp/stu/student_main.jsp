
<%@ page import="bean.clz.DetailClass" %>
<%@ page import="bean.stu.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="classes" class="bean.clz.DetailClassList" scope="session"/>
<jsp:useBean id="choose" class="bean.sc.Choose" scope="session"/>
<html>
<head>
    <meta charset="utf-8">
    <title>NUC选修管理系统</title>
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="../../css/ems.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <script src="../../js/yq.js" type="text/javascript"> </script>
</head>
<body>

<div id="main_bg">
    <!-- Header -->
    <header>
        <nav>
            <div id="logo">
                <a href="../../servlet/stu/StudentMainServlet?page=1" >NUC选修管理系统</a>
            </div>
            <div id="avatar">
                <a href="../../servlet/stu/StudentInfoServlet?page=1">
                    <img src=<%=((Student)request.getSession().getAttribute("student")).getAvatar()%>>
                </a>
            </div>
        </nav>
        <div id ="banner">
            <div>
                <h1 id="time1">00 : 00 : 00</h1>
                <h1 id="time2">2017年1月1日星期一</h1>
                <hr>
                <%
                    if(!choose.isChoose()){
                %>
                        <p>本学期未选课</p>
                <%
                    }else{
                %>
                        <p>本学期已选课</p>
                <%
                    }
                %>

            </div>
        </div>
    </header>
    <!-- Content -->
    <div id="content">
        <div id="yq_inner">
            <%
                for(int i = 1 ;i <= 4 ;i ++){
                    String div_id = "frg" + i;
                    String a_id = "f_title" + i;
                    String p_id = "f_des" + i;
                    if(i-1 < classes.getList().size()){
                        DetailClass clz = classes.getList().get(i-1);
                        String cname = clz.getCname();
                        String tname = clz.getTname();
            %>
                        <div id=<%=div_id%>>
                            <a id=<%=a_id%> class="title" href="../../servlet/clz/StudentClassDetailServlet?clzno=<%=clz.getClzno()%>"><%=cname%></a>
                            <p id=<%=p_id%> class="des"><%=tname%></p>
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
