<%@ page import="bean.clz.DetailClass" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="teacher" class="bean.teacher.Teacher" scope="session"/>
<jsp:useBean id="classes" class="bean.clz.DetailClassList" scope="session"/><%-- 课程列表 --%>
<html>
<head>
    <title>教师信息</title>
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="../../css/ems.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <script src="../../js/yq.js" type="text/javascript"> </script>
</head>
<body>

<div id="main_bg">
    <!-- Header -->
    <header>
        <nav>
            <div id="logo">
                <a href="../../servlet/teacher/TeacherInfoServlet?page=1" >中北大学选修管理系统</a>
            </div>
        </nav>
        <div id ="banner">
            <div>
                <img src="<%=teacher.getAvatar()%>">
                <h1><%=teacher.getName()%>(No.<%=teacher.getTno()%>)</h1>
                <a href="#"  onclick="login()"> <%-- 触发 js 点击事件 , 出现修改框 --%>
                    修改信息
                </a>
            </div>
        </div>
    </header>
    <!-- Content -->
    <div id="content">
        <div>
            <%-- 拼接已选课历史信息html --%>
            <%
                for(int i = 1 ;i <= 4 ;i ++){
                    String div_id = "frg" + i; /* 拼接对应 css */
                    String a_id = "f_title" + i; /* 拼接对应 css */
                    String p_id = "f_des" + i; /* 拼接对应 css */
                    if(i-1 < classes.getList().size()){ /* list 从 0 计数, 因此 i - 1*/
                        DetailClass clz = classes.getList().get(i-1);
                        String name = clz.getCname();
                        /* 将时间类型long 转为 String*/
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        Date date = new Date(clz.getStart());
                        String time = format.format(date);
            %>
            <div id=<%=div_id%>>
                <%-- 课程详细 --%>
                <a id=<%=a_id%> class="title" href="../../servlet/teacher/TeacherClassDetailServlet?clzno=<%=clz.getClzno()%>"><%=name%></a>
                <p id=<%=p_id%> class="des">开课时间：<%=time%></p>
            </div>
            <%
            }else{
            %>
            <div id=<%=div_id%>></div>
            <%
                    }
                }
            %>
        </div>
    </div>
    <!-- 导航栏 -->
    <%@include file="../widght/bar.jsp"%>
</div>

<%-- 信息更新框 --%>
<div id="login">
    <div id="login_info">
        <img class="cancel" src="../../img/cancel.png" onclick="back()"> <%-- 点击触发 js 事件, 将更新框隐藏 --%>
        <form name="form" method="post" action="/servlet/teacher/GradeServlet">
            <input class="form_input" type="text" name="tno" value="<%=teacher.getTno()%>" readonly="readonly"><br> <%-- readonly 只读, 不可编辑, 保持主键不被修改--%>
            <input class="form_input" type="text" name="tname" value="<%=teacher.getName()%>" readonly="readonly"><br>
            <input class="form_input" type="text" name="tsex" value="<%=teacher.getSex()%>" readonly="readonly"><br>
            <input class="form_input" type="text" name="password" value="<%=teacher.getPassword()%>" placeholder="密  码"><br>
            <input class="form_input" type="text" name="avatar" value="<%=teacher.getAvatar()%>" placeholder="头  像"><br>
            <input class = "form_bt" type="submit" value="确认">
            <input class = "form_bt" type="reset" value="重置">
        </form>
    </div>
</div>

</body>
</html>
