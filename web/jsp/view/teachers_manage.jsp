<%@ page import="bean.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="teachers" class="bean.TeacherWrapper" scope="session"/>
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
                    <td align="center">密  码</td>
                    <td align="center">修  改</td>
                    <td align="center">删  除</td>
                </tr>
                <%
                    List<Teacher> teacher = teachers.getList();
                    for(int i = 0 ;i < teacher.size() ;i ++){
                %>
                <tr>
                    <td align="center"><%=teacher.get(i).getTno()%></td>
                    <td align="center"><%=teacher.get(i).getTname()%></td>
                    <td align="center"><%=teacher.get(i).getTsex()%></td>
                    <td align="center"><%=teacher.get(i).getPassword()%></td>
                    <td align="center">
                        <a href="teacher_update.jsp?tno=<%=teacher.get(i).getTno()%>&tname=<%=teacher.get(i).getTname()%>&tsex=<%=teacher.get(i).getTsex()%>&password=<%=teacher.get(i).getPassword()%>">修改</a>
                    </td>
                    <td align="center">
                        <a href="">删除</a>
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
</div>

</body>
</html>
