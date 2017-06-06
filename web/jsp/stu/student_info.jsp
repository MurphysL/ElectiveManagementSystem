<%@ page import="bean.sc.DetailSC" %>
<%@ page import="bean.stu.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="scs" class="bean.sc.DetailSCList" scope="session"/> <%-- 选课记录 list--%>
<jsp:useBean id="student" class="bean.stu.Student" scope="session"/> <%-- 学生信息 --%>
<html>
<head>
    <meta charset="utf-8">
    <title>学生信息</title>
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
                <a href="../../servlet/stu/StudentMainServlet?page=1" >自主选课</a> <%-- 跳转至选课模块 --%>
            </div>
            <div id="avatar">
                <a href="../../servlet/stu/StudentInfoServlet?page=1"> <%-- 跳转学生信息模块 --%>
                    <img src=<%=((Student)request.getSession().getAttribute("student")).getAvatar()%>> <%-- 头像 （不是阿凡达..）--%>
                </a>
            </div>
        </nav>
        <div id ="banner">
            <div> <%-- 学生信息展示 --%>
                <img src="<%=student.getAvatar()%>" style="width:150px;height:150px;border-radius:75px;">
                <h1><%=student.getName()%>(no.<%=student.getSno()%>)</h1>
                <h4 style="margin-top: 60px;color: white;align-items: center;text-align: center;"><%=student.getDept()%></h4>
                <a href="#" onclick="login()"> <%-- 触发 js 点击事件 , 出现修改框 --%>
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
                for(int i = 1 ;i <= 4 ;i ++){ /* 依次从历史信息 list 中,取出单独信息*/
                    String div_id = "frg" + i; /* 拼接对应 css */
                    String a_id = "f_title" + i; /* 拼接对应 css */
                    String p_id = "f_des" + i; /* 拼接对应 css */
                    if(i-1 < scs.getList().size()){  /* list 从 0 计数, 因此 i - 1*/
                        DetailSC Sc = scs.getList().get(i-1);
                        String cname = Sc.getCname();
                        String tname = Sc.getTname();
            %>
                <div id=<%=div_id%>>
                    <%-- 点击课程名跳转 --%>
                    <a id=<%=a_id%> class="title" href="../../servlet/stu/SCDetailServlet?clzno=<%=Sc.getClzno()%>&sno=<%=Sc.getSno()%>"><%=cname%></a>
                    <%-- 教师名 --%>
                     <p id=<%=p_id%> class="des"><%=tname%></p>
                </div>
            <%
            }else{ /* 没有更多历史数据,空 div 保持页面完整 */
            %>
            <div id=<%=div_id%>></div>
            <%
                    }
                }
            %>
        </div>
    </div>
    <!-- Bar -->
    <%@include file="../widght/bar.jsp"%> <%-- 导航条 --%>
</div>

<%-- 信息更新框 --%>
<div id="login">
    <div id="login_info">
        <img class="cancel" src="../../img/cancel.png" onclick="back()"> <%-- 点击触发 js 事件, 将更新框隐藏 --%>
        <form name="form" method="post" action="/servlet/stu/StudentUpdateInfoServlet">
            <input class="form_input" type="text" name="sno" value="<%=student.getSno()%>" readonly="readonly"><br> <%-- readonly 只读, 不可编辑, 保持主键不被修改--%>
            <input class="form_input" type="text" name="name" value="<%=student.getName()%>" readonly="readonly"><br>
            <input class="form_input" type="text" name="sex" value="<%=student.getSex()%>" readonly="readonly"><br>
            <input class="form_input" type="text" name="dept" value="<%=student.getDept()%>" readonly="readonly"><br>
            <input class="form_input" type="text" name="password" value="<%=student.getPassword()%>" placeholder="密  码"><br>
            <input class="form_input" type="text" name="avatar" value="<%=student.getAvatar()%>" placeholder="头  像"><br>
            <input class = "form_bt" type="submit" value="确认">
            <input class = "form_bt" type="reset" value="重置">
        </form>
    </div>
</div>

</body>
</html>
