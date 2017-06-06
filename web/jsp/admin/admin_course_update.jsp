<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>科目信息修改</title>
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="../../css/ems.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <script src="../../js/yq.js" type="text/javascript"> </script>
</head>
<body>

<%
    int cno = Integer.parseInt(request.getParameter("cno"));
    String name = request.getParameter("name");
    int credit = Integer.parseInt(request.getParameter("credit"));
    int duration = Integer.parseInt(request.getParameter("duration"));
%>

<div id="main_bg">
    <header>
        <nav>
            <div id="logo">
                <a href="student_manage.jsp" >返回上一级</a>
            </div>
        </nav>
        <div id ="banner"></div>
    </header>
</div>

<div id="update">
    <div id="login_info">
        <img class="cancel" src="../../img/cancel.png" onclick="update_back()">
        <form name="form" method="post" action="/servlet/admin/CourseUpdateServlet">
            <input class="form_input" type="text" name="cno" value="<%=cno%>" readonly="readonly">
            <input class="form_input" type="text" name="name" value="<%=name%>" placeholder="科目名">
            <input class="form_input" type="text" name="credit" value="<%=credit%>"  placeholder="学  分">
            <input class="form_input" type="text" name="duration" value="<%=duration%>" placeholder="周  数">
            <input class = "form_bt"  type="submit" value="确认">
            <input class = "form_bt"  type="reset" value="重置">
        </form>
    </div>
</div>

</body>
</html>
