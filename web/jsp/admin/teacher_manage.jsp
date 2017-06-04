<%@ page import="bean.teacher.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="teachers" class="bean.teacher.TeacherList" scope="session"/>
<html>
<head>
    <title>教师信息管理</title>
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
            <a href="../../servlet/admin/TeacherManageServlet?page=1" >NUC选修管理系统</a>
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
                    <td align="center"><%=teacher.get(i).getName()%></td>
                    <td align="center"><%=teacher.get(i).getSex()%></td>
                    <td align="center"><%=teacher.get(i).getPassword()%></td>
                    <td align="center">
                        <a href="../admin/admin_teacher_update.jsp?tno=<%=teacher.get(i).getTno()%>&tname=<%=teacher.get(i).getName()%>&tsex=<%=teacher.get(i).getSex()%>&password=<%=teacher.get(i).getPassword()%>&avatar=<%=teacher.get(i).getAvatar()%>">修改</a>
                    </td>
                    <td align="center">
                        <a href="../../servlet/admin/TeacherDeleteServlet?tno=<%=teacher.get(i).getTno()%>">删除</a>
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
