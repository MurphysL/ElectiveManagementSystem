<%@ page import="bean.clz.DetailClass" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="classes" class="bean.clz.DetailClasses" scope="session"/>
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

<!-- Nav -->
<div id="main_bg">
    <nav>
        <div id="logo">
            <a href="#" >NUC选修管理系统</a>
        </div>
    </nav>
</div>

<!-- Main -->
<section id="main">
    <div class="inner">
        <header>
            <table  align="center" border="2" width="1000px" height="50px">
                <tr>
                    <td align="center">科目号</td>
                    <td align="center">科目名</td>
                    <td align="center">学  分</td>
                    <td align="center">教工号</td>
                    <td align="center">教师名</td>
                    <td align="center">性  别</td>
                    <td align="center">地  址</td>
                    <td align="center">时  间</td>
                </tr>
                <%
                    List<DetailClass> list = classes.getList();
                    for(int i = 0 ;i < list.size() ;i ++){
                %>
                <tr>
                    <td align="center"><%=list.get(i).getCno()%></td>
                    <td align="center"><%=list.get(i).getCname()%></td>
                    <td align="center"><%=list.get(i).getCcredit()%></td>
                    <td align="center"><%=list.get(i).getTno()%></td>
                    <td align="center"><%=list.get(i).getTname()%></td>
                    <td align="center"><%=list.get(i).getTsex()%></td>
                    <td align="center"><%=list.get(i).getAddress()%></td>
                    <td align="center"><%=list.get(i).getTime()%></td>
                    <td align="center">
                        <a href="student_update.jsp?cno=<%=list.get(i).getCno()%>&name=<%=list.get(i).getCname()%>&credit=<%=list.get(i).getCcredit()%>&tno=<%=list.get(i).getTno()%>&tname=<%=list.get(i).getTname()%>&tsex=<%=list.get(i).getTsex()%>&address=<%=list.get(i).getAddress()%>&time=<%=list.get(i).getTime()%>">修改</a>
                    </td>
                    <td align="center">
                        <a href="../../servlet/ClassDeleteServlet?cno=<%=list.get(i).getCno()%>&tno=<%=list.get(i).getTno()%>&time=<%=list.get(i).getTime()%>">删除</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>

        </header>
    </div>
</section>
<!-- Bar -->
<%@include file="../widght/bar.jsp"%>

</body>
</html>
