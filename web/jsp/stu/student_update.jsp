<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="student" class="bean.stu.Student" scope="session"/>
<html>
<head>
    <title>修改信息</title>
</head>
<body>

<form action="/servlet/stu/StudentUpdateInfoServlet" method="post">
    教工号：<input type="text" name="sno" value="<%=student.getSno()%>"><br>
    姓  名：<input type="text" name="name" value="<%=student.getName()%>"><br>
    性  别：<input type="text" name="sex" value="<%=student.getSex()%>"><br>
    院  系：<input type="text" name="dept" value="<%=student.getDept()%>"><br>
    密  码：<input type="text" name="password" value="<%=student.getPassword()%>"><br>
    头  像：<input type="text" name="avatar" value="<%=student.getAvatar()%>"><br>
    <input type="submit" value="确认"> <input type="reset" value="重置">
</form>

</body>
</html>
