
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新成功</title>
</head>
<body>
<h1 align="center">更新成功</h1>
<%
    response.setHeader("refresh","2;URL=../../servlet/stu/StudentInfoServlet?page=1");
%>
</body>
</html>
