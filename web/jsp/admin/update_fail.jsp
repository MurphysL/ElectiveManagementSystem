
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新失败</title>
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
</head>
<body>
<h1 align="center">更新失败!!</h1>
<%
    response.setHeader("refresh","2;URL=../../servlet/admin/ClassManageServlet?page=1");
%>
</body>
</html>
