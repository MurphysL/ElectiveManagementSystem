
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息添加</title>
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="../../css/ems.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <script src="../../js/yq.js" type="text/javascript"> </script>
</head>
<body>

<div id="main_bg">
    <header>
        <nav>
            <div id="logo">
                <a href="class_manage.jsp" >返回上一级</a>
            </div>
        </nav>
        <div id ="banner"></div>
    </header>
</div>

<div id="update">
    <div id="login_info">
        <img class="cancel" src="../../img/cancel.png" onclick="update_back()">
        <form name="form" method="post" action="/servlet/admin/ClassInsertServlet">
            <input class="form_input" type="text" name="cno" placeholder="课程号">
            <input class="form_input" type="text" name="tno" placeholder="教师号">
            <input class="form_input" type="text" name="start" placeholder="开始时间（1980-1-1 12:12)">
            <input class="form_input" type="text" name="address" placeholder="地  址">
            <input class = "form_bt"  type="submit" value="确认">
            <input class = "form_bt"  type="reset" value="重置">
        </form>
    </div>
</div>

</body>
</html>

