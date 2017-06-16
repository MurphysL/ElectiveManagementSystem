<%@ page import="java.util.List" %>
<%@ page import="bean.course.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="courses" class="bean.course.CourseList" scope="session"/>
<html>
<head>
    <meta charset="utf-8">
    <title>科目信息管理</title>
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
            <a href="admin_main.jsp" >中北大学选修管理系统</a>
        </div>
        <div id="new">
            <a href="course_insert.jsp"><img src="../../img/cancel.png"></a>
        </div>
    </nav>
</div>

<!-- Main -->
<section id="main">
    <div class="inner">
        <header>
            <table  align="center" border="2" width="1000px">
                <tr>
                    <td align="center">科目号</td>
                    <td align="center">科目名</td>
                    <td align="center">学  分</td>
                    <td align="center">周  数</td>
                    <td align="center">修  改</td>
                    <td align="center">删  除</td>
                </tr>
                <%
                    List<Course> list = courses.getList();
                    for(int i = 0 ;i < 10 ;i ++){
                        if(i < list.size()){
                %>
                <tr>
                    <td align="center"><%=list.get(i).getCno()%></td>
                    <td align="center"><%=list.get(i).getName()%></td>
                    <td align="center"><%=list.get(i).getCredit()%></td>
                    <td align="center"><%=list.get(i).getDuration()%></td>
                    <td align="center">
                        <a href="../admin/admin_course_update.jsp?cno=<%=list.get(i).getCno()%>&name=<%=list.get(i).getName()%>&credit=<%=list.get(i).getCredit()%>&duration=<%=list.get(i).getDuration()%>">修改</a>
                    </td>
                    <td align="center">
                        <a href="../../servlet/admin/CourseDeleteServlet?cno=<%=list.get(i).getCno()%>">删除</a>
                    </td>
                </tr>
                <%
                }else{
                %>
                <tr>
                    <td align="center" height="25px"></td>
                    <td align="center" height="25px"></td>
                    <td align="center" height="25px"></td>
                    <td align="center" height="25px"></td>
                    <td align="center" height="25px"></td>
                    <td align="center" height="25px"></td>
                </tr>
                <%
                        }
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
