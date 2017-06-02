
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="admin" class="bean.Admin" scope="session"/>
<html>
<head>
    <meta charset="utf-8">
    <title>NUC选修管理系统</title>
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="../../css/yq.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <script src="../../js/yq.js" type="text/javascript"> </script>
</head>
<body>

<div id="main_bg">
    <!-- Header -->
    <header>
        <nav>
            <div id="logo">
                <a href="#" >NUC选修管理系统</a>
            </div>
        </nav>
        <div id ="yq_banner">
            <div>
                <h1 id="yq_time1">00 : 00 : 00</h1>
                <h1 id="yq_time2">2017年1月1日星期一</h1>
            </div>
        </div>
    </header>
    <!-- Content -->
    <div id="yq_content">
        <div id="yq_inner">
            <div id="yq_frg1">
                <img src="../../img/pic1.jpg" id="f_img1">
                <a id="f_title1" class="title" href="../../servlet/TeacherManageServlet?page=1">教师管理</a>
            </div>
            <div id="yq_frg2">
                <img src="../../img/pic1.jpg" id="f_img2">
                <a id="f_title2" class="title" href="../../servlet/StudentManageServlet?page=1">学生管理</a>
            </div>
            <div id="yq_frg3">
                <img src="../../img/pic1.jpg" id="f_img3">
                <a id="f_title3" class="title" href="../../servlet/ClassDetailServlet">课程管理</a>
            </div>
            <div id="yq_frg4">

            </div>
        </div>
    </div>
    <!-- Bar -->
    <%@include file="../widght/bar.jsp"%>
</div>

</body>
</html>
