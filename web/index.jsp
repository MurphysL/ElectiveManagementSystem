
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>NUC选修管理系统</title>
    <link rel="icon" href="img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="css/yq.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <script src="js/yq.js" type="text/javascript"> </script>
</head>
<body>

<div id="main_bg">
    <%-- 登录 --%>
    <%@include file="jsp/widght/view_login.jsp"%>

    <%-- 首页 --%>
    <header>
        <%@include file="jsp/widght/nav_unlogin.jsp" %>
        <%@include file="jsp/widght/banner.jsp" %>
    </header>
</div>

</body>
</html>
