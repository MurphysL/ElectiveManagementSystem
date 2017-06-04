<%@ page import="bean.clz.DetailClass" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="self_classes" class="bean.clz.DetailClassList" scope="session"/>
<jsp:useBean id="student" class="bean.stu.Student" scope="session"/>
<html>
<head>
    <meta charset="utf-8">
    <title>MBlog</title>
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="../../css/ems.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <script src="../../js/yq.js" type="text/javascript"> </script>
</head>
<body>

<div id="main_bg">
    <!-- Header -->
    <header>
        <%@include file="../widght/nav_login.jsp" %>
        <div id ="yq_banner">
            <div>
                <img src=<%=student.getAvatar()%> style="width:150px;height:150px;border-radius:75px;">
                <h1><%=student.getSname()%></h1>
                <h4 style="margin-top: 60px;color: white;align-items: center;text-align: center;">
                    <%=student.getSno()%></h4>
                <h4 style="margin: 0;color: white;align-items: center;text-align: center;">
                    已选修科目 <%=self_classes.getNum()%> 门
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
                    if(i-1 < self_classes.getList().size()){
                        DetailClass clz = self_classes.getList().get(i-1);
                        String cname = clz.getCname();
                        String teacher = clz.getTname();
            %>
                <div id=<%=div_id%>>
                    <img src="../../img/pic1.jpg" id=<%=img_id%>>
                    <a id=<%=a_id%> class="title" href="../../servlet/ClassDetailServlet?cno=<%=clz.getCno()%>&tno=<%=clz.getTno()%>"><%=cname%></a>
                    <p id=<%=p_id%> class="des"><%=teacher%></p>
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
