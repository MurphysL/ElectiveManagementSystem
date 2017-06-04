<%@ page import="bean.stu.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="students" class="bean.stu.StudentList" scope="session"/>
<html>
<head>
    <title>学生信息管理</title>
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
                    <td align="center"><%=list.get(i).getName()%></td>
                    <td align="center"><%=list.get(i).getSex()%></td>
                    <td align="center"><%=list.get(i).getDept()%></td>
                    <td align="center"><%=list.get(i).getPassword()%></td>
                    <td align="center">
                        <a href="../admin/admin_student_update.jsp?sno=<%=list.get(i).getSno()%>&name=<%=list.get(i).getName()%>&sex=<%=list.get(i).getSex()%>&dept=<%=list.get(i).getDept()%>&password=<%=list.get(i).getPassword()%>&avatar=<%=list.get(i).getAvatar()%>">修改</a>
                    </td>
                    <td align="center">
                        <a href="../../servlet/admin/StudentDeleteServlet?sno=<%=list.get(i).getSno()%>">删除</a>
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
