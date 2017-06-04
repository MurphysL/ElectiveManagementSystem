
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="update_teacher" class="bean.teacher.Teacher"/>
<html>
<head>
    <title>学生信息修改</title>
</head>
<body>

<%
    int sno = Integer.parseInt(request.getParameter("sno"));
    String name = request.getParameter("name");
    String sex = request.getParameter("sex");
    String dept = request.getParameter("dept");
    String password = request.getParameter("password");
    String avatar = request.getParameter("avatar");
%>

<form action="/servlet/admin/StudentUpdateServlet" method="post">
    教工号： <input type="text" name="sno" value="<%=sno%>">
    姓  名：<input type="text" name="name" value="<%=name%>">
    性  别：<input type="text" name="sex" value="<%=sex%>">
    院  系：<input type="text" name="dept" value="<%=dept%>">
    密  码：<input type="text" name="password" value="<%=password%>">
    头  像：<input type="text" name="avatar" value="<%=avatar%>">
    <input type="submit" value="确认"> <input type="reset" value="重置">
</form>

</body>
</html>
