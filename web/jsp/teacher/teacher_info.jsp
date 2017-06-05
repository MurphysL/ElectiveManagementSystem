<%@ page import="bean.clz.DetailClass" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="teacher" class="bean.teacher.Teacher" scope="session"/>
<jsp:useBean id="classes" class="bean.clz.DetailClassList" scope="session"/>
<html>
<head>
    <title>教师信息</title>
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
                <a href="../../servlet/teacher/TeacherInfoServlet?page=1" >NUC选修管理系统</a>
            </div>
        </nav>
        <div id ="banner">
            <div>
                <img src="<%=teacher.getAvatar()%>">
                <h1><%=teacher.getName()%>(No.<%=teacher.getTno()%>)</h1>
                <a href="../teacher/teacher_update.jsp">
                    修改信息
                </a>
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
                        String name = clz.getCname();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        Date date = new Date(clz.getStart()*1000);
                        String time = format.format(date);
            %>
            <div id=<%=div_id%>>
                <a id=<%=a_id%> class="title" href="../../servlet/teacher/TeacherClassDetailServlet?clzno=<%=clz.getClzno()%>"><%=name%></a>
                <p id=<%=p_id%> class="des">开课时间：<%=time%></p>
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
