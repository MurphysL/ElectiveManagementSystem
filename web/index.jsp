
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>NUC选修管理系统</title>
    <link rel="icon" href="img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="css/ems.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <script src="js/yq.js" type="text/javascript"> </script>
</head>
<body>

<div id="main_bg">
    <%-- 登录 --%>
    <%@include file="jsp/widght/view_login.jsp"%>

    <%-- 首页 --%>
    <header>
        <nav>
            <div id="logo">
                <a href="#" >NUC选修管理系统</a>
            </div>
            <ul>
                <li><a href="#" onclick="login()">登录</a></li>
            </ul>
        </nav>
        <div id ="banner">
            <div>
                <h1 id="time1">00 : 00 : 00</h1>
                <h1 id="time2">2017年1月1日星期一</h1>
                <hr>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
            </div>
        </div>
    </header>
</div>

</body>
</html>
