
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>修改信息</title>
</head>
<body>

<%
    int tno = Integer.parseInt(request.getParameter("tno"));
    String tname = request.getParameter("tname");
    String tsex = request.getParameter("tsex");
    String password = request.getParameter("password");
    String avatar = request.getParameter("avatar");
%>

<form action="/servlet/admin/TeacherUpdateServlet" method="post">
    教工号：<input type="text" name="tno" value="<%=tno%>">
    姓  名：<input type="text" name="tname" value="<%=tname%>">
    性  别：<input type="text" name="tsex" value="<%=tsex%>">
    密  码：<input type="text" name="password" value="<%=password%>">
    头  像：<input type="text" name="avatar" value="<%=avatar%>">
    <input type="submit" value="确认"> <input type="reset" value="重置">
</form>

</body>
</html>
