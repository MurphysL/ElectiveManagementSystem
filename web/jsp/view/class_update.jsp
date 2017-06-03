<%--
  只允许更改地址
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    int cno = Integer.parseInt(request.getParameter("cno"));
    String cname = request.getParameter("cname");
    int credit = Integer.parseInt(request.getParameter("credit"));
    int tno = Integer.parseInt(request.getParameter("tno"));
    String tname = request.getParameter("tname");
    String tsex = request.getParameter("tsex");
    String address = request.getParameter("address");
    Long time = Long.parseLong(request.getParameter("time"));
%>

<form action="/servlet/StudentUpdateServlet" method="post">
    课程号： <input type="text" name="cno" value="<%=cno%>">
    课程名：<input type="text" name="cname" value="<%=cname%>">、
    学  分：<input type="text" name="credit" value="<%=credit%>">
    教工号：<input type="text" name="tno" value="<%=tno%>">
    教师名：<input type="text" name="tname" value="<%=tname%>">
    性  别：<input type="text" name="tsex" value="<%=tsex%>">
    地  址：<input type="text" name="address" value="<%=address%>">
    时  间：<input type="text" name="time" value="<%=time%>">
    <input type="submit" value="确认"> <input type="reset" value="重置">
</form>

</body>
</html>
