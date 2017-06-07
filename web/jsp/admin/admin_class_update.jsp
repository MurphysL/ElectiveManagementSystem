<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.ParseException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>课程信息修改</title>
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="../../css/ems.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <script src="../../js/yq.js" type="text/javascript"> </script>
</head>
<body>

<%
    int clzno = Integer.parseInt(request.getParameter("clzno"));
    long start = Long.parseLong(request.getParameter("start"));
    String address = request.getParameter("address");
    int cno = Integer.parseInt(request.getParameter("cno"));
    int tno = Integer.parseInt(request.getParameter("tno"));

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    String time = format.format(start);
%>

<div id="main_bg">
    <header>
        <nav>
            <div id="logo">
                <a href="../../servlet/admin/ClassManageServlet?page=1" >返回上一级</a>
            </div>
        </nav>
        <div id ="banner"></div>
    </header>
</div>

<div id="update">
    <div id="login_info">
        <img class="cancel" src="../../img/cancel.png" onclick="update_back()">
        <form name="form" method="post" action="/servlet/admin/ClassUpdateServlet">
            <input class="form_input" type="text" name="clzno" value="<%=clzno%>" readonly="readonly">
            <input class="form_input" type="text" name="cno" value="<%=cno%>" placeholder="课程号">
            <input class="form_input" type="text" name="tno" value="<%=tno%>" placeholder="教师号">
            <input class="form_input" type="text" name="start" value="<%=time%>"  placeholder="开课时间（1980-1-1 12:12)">
            <input class="form_input" type="text" name="address" value="<%=address%>" placeholder="地址">
            <input class = "form_bt"  type="submit" value="确认">
            <input class = "form_bt"  type="reset" value="重置">
        </form>
    </div>
</div>

</body>
</html>
