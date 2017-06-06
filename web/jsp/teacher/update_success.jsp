
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新成功</title>
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
            <a href="#" >中北大学选修管理系统</a>
        </div>
    </nav>

    <div id="hint">
        <div>
            <h1>更新成功</h1>
        </div>
    </div>

</div>

<%
    response.setHeader("refresh","2;URL=../../servlet/teacher/TeacherInfoServlet?page=1");
%>

</body>
</html>
