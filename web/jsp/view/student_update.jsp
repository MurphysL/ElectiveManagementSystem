
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="update_teacher" class="bean.teacher.Teacher"/>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    int sno = Integer.parseInt(request.getParameter("sno"));
    String sname = request.getParameter("sname");
    String ssex = request.getParameter("ssex");
    String sdept = request.getParameter("sdept");
    String password = request.getParameter("password");
%>

<form action="/servlet/StudentUpdateServlet" method="post">
    教工号： <input type="text" name="sno" value="<%=sno%>">
    姓  名：<input type="text" name="sname" value="<%=sname%>">
    性  别：<input type="text" name="ssex" value="<%=ssex%>">
    院  系：<input type="text" name="sdept" value="<%=sdept%>">
    密  码：<input type="text" name="password" value="<%=password%>">
    <input type="submit" value="确认"> <input type="reset" value="重置">
</form>

</body>
</html>
