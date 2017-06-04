
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="update_teacher" class="bean.teacher.Teacher"/>
<html>
<head>
    <title>学生信息修改</title>
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="../../css/ems.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <script src="../../js/yq.js" type="text/javascript"> </script>
</head>
<body>

<%
    int clzno = Integer.parseInt(request.getParameter("clzno"));
    long start = Long.parseLong(request.getParameter("start"));
    String address = request.getParameter("address");
    int cno = Integer.parseInt(request.getParameter("cno"));
    int tno = Integer.parseInt(request.getParameter("tno"));
%>

<form action="/servlet/admin/ClassUpdateServlet" method="post">
    编  号： <input type="text" name="clzno" value="<%=clzno%>"><br>
    课程号：<input type="text" name="cno" value="<%=cno%>"><br>
    起始时间：<input type="text" name="start" value="<%=start%>"><br>
    地  址：<input type="text" name="address" value="<%=address%>"><br>
    教师号：<input type="text" name="tno" value="<%=tno%>"><br>
    <input type="submit" value="确认"> <input type="reset" value="重置">
</form>

</body>
</html>
