
<%--
管理员 教师 修改信息冲突--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="teacher" class="bean.teacher.Teacher" scope="session"/>
<html>
<head>
    <title>修改信息</title>
</head>
<body>

<form action="/servlet/teacher/TeacherUpdateInfoServlet" method="post">
    教工号：<input type="text" name="tno" value="<%=teacher.getTno()%>">
    姓  名：<input type="text" name="tname" value="<%=teacher.getName()%>">
    性  别：<input type="text" name="tsex" value="<%=teacher.getSex()%>">
    密  码：<input type="text" name="password" value="<%=teacher.getPassword()%>">
    头  像：<input type="text" name="avatar" value="<%=teacher.getAvatar()%>">
    <input type="submit" value="确认"> <input type="reset" value="重置">
</form>

</body>
</html>
