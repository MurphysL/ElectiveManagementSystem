<%@ page import="bean.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/6/2
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="students" class="bean.StudentWrapper" scope="session"/>
<html>
<head>
    <title>Title</title>
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
                    <td align="center">教工号</td>
                    <td align="center">姓  名</td>
                    <td align="center">性  别</td>
                    <td align="center">院  系</td>
                    <td align="center">密  码</td>
                    <td align="center">修  改</td>
                    <td align="center">删  除</td>
                </tr>
                <%
                    List<Student> list = students.getList();
                    for(int i = 0 ;i < list.size() ;i ++){
                %>
                <tr>
                    <td align="center"><%=list.get(i).getSno()%></td>
                    <td align="center"><%=list.get(i).getSname()%></td>
                    <td align="center"><%=list.get(i).getSsex()%></td>
                    <td align="center"><%=list.get(i).getSdept()%></td>
                    <td align="center"><%=list.get(i).getPassword()%></td>
                    <td align="center">
                        <a href="student_update.jsp?sno=<%=list.get(i).getSno()%>&sname=<%=list.get(i).getSname()%>&ssex=<%=list.get(i).getSsex()%>&sdept=<%=list.get(i).getSdept()%>&password=<%=list.get(i).getPassword()%>">修改</a>
                    </td>
                    <td align="center">
                        <a href="../../servlet/StudentDeleteServlet?sno=<%=list.get(i).getSno()%>">删除</a>
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
