
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
                <a href="student_manage.jsp" >返回上一级</a>
            </div>
        </nav>
        <div id ="banner"></div>
    </header>
</div>

<div id="update">
    <div id="login_info">
        <img class="cancel" src="../../img/cancel.png" onclick="update_back()">
        <form name="form" method="post" action="/servlet/admin/StudentInsertServlet">
            <input class="form_input" type="text" name="sno" placeholder="学  号">
            <input class="form_input" type="text" name="name" placeholder="姓  名">
            <input class="form_input" type="text" name="sex" placeholder="性  别">
            <input class="form_input" type="text" name="dept" placeholder="院  系">
            <input class="form_input" type="text" name="password" placeholder="密  码">
            <input class = "form_bt"  type="submit" value="确认">
            <input class = "form_bt"  type="reset" value="重置">
        </form>
    </div>
</div>

</body>
</html>

