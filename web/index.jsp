
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
    <link rel="icon" href="img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="css/ems.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <script src="js/yq.js" type="text/javascript"> </script>
</head>
<body>

<div id="main_bg">
    <%-- 登录 --%>
        <div id="login">
            <div id="login_info">
                <img class="cancel" src="../../img/cancel.png" onclick="back()">
                <form name="form" method="post" action="../../servlet/LoginServlet" onsubmit="return check()">
                    <input class="form_input" type="text" name="no" placeholder="学   号/教工号/管理员号"><br>
                    <input class="form_input" type="password" name="password" placeholder="密    码"><br>
                    <select class="form_input" name="type">
                        <option value="student">学&nbsp;&nbsp;&nbsp;生</option>
                        <option value="teacher">教&nbsp;&nbsp;&nbsp;师</option>
                        <option value="admin">管理员</option>
                    </select><br>
                    <input class = "form_bt" type="submit" value="确认">
                    <input class = "form_bt" type="reset" value="重置">
                </form>
            </div>
        </div>

    <%-- 首页 --%>
    <header>
        <nav>
            <div id="logo">
                <a href="#" >中北大学选修管理系统</a>
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
                <p>不闻不若闻之，闻之不若见之，见之不若知之，知之不若行之。</p>
                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;——《儒效》</p>
            </div>
        </div>
    </header>
</div>

</body>
</html>
