<%@ page import="bean.sc.DetailSC" %>
<%@ page import="bean.stu.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="scs" class="bean.sc.DetailSCList" scope="session"/>
<jsp:useBean id="student" class="bean.stu.Student" scope="session"/>
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
                <img src="<%=student.getAvatar()%>" style="width:150px;height:150px;border-radius:75px;">
                <h1><%=student.getName()%></h1>
                <h4 style="margin-top: 60px;color: white;align-items: center;text-align: center;"><%=student.getSno()%></h4>
                <a href="../stu/student_update.jsp">
                    修改信息
                </a>
            </div>
        </div>
    </header>
    <!-- Content -->
    <div id="content">
        <div>
            <%
                for(int i = 1 ;i <= 4 ;i ++){
                    String div_id = "frg" + i;
                    String a_id = "f_title" + i;
                    String p_id = "f_des" + i;
                    if(i-1 < scs.getList().size()){
                        DetailSC Sc = scs.getList().get(i-1);
                        String cname = Sc.getCname();
                        String tname = Sc.getTname();
            %>
                <div id=<%=div_id%>>
                    <a id=<%=a_id%> class="title" href="../../servlet/stu/SCDetailServlet?clzno=<%=Sc.getClzno()%>&sno=<%=Sc.getSno()%>"><%=cname%></a>
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
