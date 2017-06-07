<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>教师信息修改</title>
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="../../css/ems.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <script src="../../js/yq.js" type="text/javascript"> </script>
</head>
<body>

<%
    int tno = Integer.parseInt(request.getParameter("tno"));
    String tname = request.getParameter("tname");
    String tsex = request.getParameter("tsex");
    String password = request.getParameter("password");
    String avatar = request.getParameter("avatar");
%>

<div id="main_bg">
    <header>
        <nav>
            <div id="logo">
                <a href="../../servlet/admin/TeacherManageServlet?page=1" >返回上一级</a>
            </div>
        </nav>
        <div id ="banner"></div>
    </header>
</div>

<div id="update">
    <div id="login_info">
        <form name="form" method="post" action="/servlet/admin/TeacherUpdateServlet">
            <input class="form_input" type="text" name="tno" value="<%=tno%>" readonly="readonly">
            <input class="form_input" type="text" name="tname" value="<%=tname%>" placeholder="姓  名">
            <input class="form_input" type="text" name="tsex" value="<%=tsex%>"  placeholder="性  别">
            <input class="form_input" type="text" name="password" value="<%=password%>" placeholder="密  码">
            <input class="form_input" type="text" name="avatar" value="<%=avatar%>" placeholder="头  像">
            <input class = "form_bt"  type="submit" value="确认">
            <input class = "form_bt"  type="reset" value="重置">
        </form>
    </div>
</div>

</body>
</html>
