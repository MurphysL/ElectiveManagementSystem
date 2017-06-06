<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="util.TimeUtil" %>
<%@ page import="bean.sc.DetailSC" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="scs" class="bean.sc.DetailSCList" scope="session"/> <%-- 选课详细列表 --%>
<jsp:useBean id="clz" class="bean.clz.DetailClass" scope="session"/> <%-- 课程详细列表 --%>
<html>
<head>
    <title><%=clz.getCname()%>(<%=clz.getTname()%>)</title>
    <meta charset="utf-8" />
    <link rel="icon" href="../../img/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="../../css/ems.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <script src="../../js/yq.js" type="text/javascript"> </script>
</head>
<body>

<!-- Nav -->
<div id="main_bg">
    <nav>
        <div id="logo">
            <a href="../../servlet/teacher/TeacherInfoServlet?page=1" >中北大学选修管理系统</a>
        </div>
    </nav>
</div>

<!-- Main -->
<section id="main">
    <div class="inner">
        <header>
            <h1><%=clz.getCname()%> ( no.<%=clz.getCno()%> )</h1>
            <p class="info">教师：<%=clz.getTname()%> ( no.<%=clz.getTno()%> )</p>
            <%
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date date = new Date(clz.getStart());
                String time = format.format(date);
            %>
            <p class="info">开课时间：<%=time%></p>
            <p class="info">开课地址：<%=clz.getAddress()%></p>
            <p class="info">学分：<%=clz.getCredit()%></p>
            <%
                long[] terms = TimeUtil.getTermTimeStamp();
                long now = System.currentTimeMillis();
                /* 开课时间晚于本学期开始时间, 结课事件晚于当前时间, 则课程正在进行中*/
                if(clz.getStart() > terms[0] && clz.getStart()+ TimeUtil.A_WEEK*clz.getDuration() > now){
            %>
            <p class="info">状态：进行中</p>
            <%
                }else{
            %>
            <p class="info">状态：已结束</p>
            <%
                }
            %>

            <form name="form" method="post" action="/servlet/teacher/GradeServlet?clzno=<%=clz.getClzno()%>">

                <table  align="center" border="1" width="1000px">
                    <tr>
                        <td align="center">学  号</td>
                        <td align="center">姓  名</td>
                        <td align="center">性  别</td>
                        <td align="center">院  系</td>
                        <td align="center">成  绩</td>
                    </tr>
                    <%
                        List<DetailSC> Sc = scs.getList();
                        int i = 0;
                        for (DetailSC aSc : Sc) {
                    %>
                    <tr>
                        <td align="center">
                            <input style="text-align: center" type="text" name="<%="no" + i%>" readonly="readonly" value="<%=aSc.getSno()%>">
                        </td>
                        <td align="center">
                            <input style="text-align: center" type="text" name="<%="name"+ i%>" readonly="readonly" value="<%=aSc.getSname()%>">
                        </td>
                        <td align="center">
                            <input style="text-align: center" type="text" name="<%="sex"+ i%>" readonly="readonly" value="<%=aSc.getSsex()%>">
                        </td>
                        <td align="center">
                            <input style="text-align: center" type="text" name="<%="dept"+ i%>" readonly="readonly" value="<%=aSc.getDept()%>">
                        </td>
                        <td align="center">
                            <input style="text-align: center" type="text" name="<%="grade"+ i%>" value="<%=aSc.getGrade()%>">
                        </td>
                    </tr>
                    <%
                            i ++;
                        }
                    %>
                </table>
                <div style="width: 400px; margin: 0 auto;" align="center">
                    <input class = "form_bt" type="submit" value="确认">
                </div>

            </form>

        </header>
    </div>
</section>

<!-- Footer -->
<footer></footer>

</body>
</html>
