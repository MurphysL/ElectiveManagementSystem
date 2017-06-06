<%@ page import="bean.clz.DetailClass" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="classes" class="bean.clz.DetailClassList" scope="session"/>
<html>
<head>
    <meta charset="utf-8">
    <title>课程信息管理</title>
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
            <a href="class_insert.jsp"><img src="../../img/cancel.png"></a>
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
                    <td align="center">地  址</td>
                    <td align="center">开始时间</td>
                    <td align="center">周  数</td>
                    <td align="center">教工号</td>
                    <td align="center">教师名</td>
                    <td align="center">性  别</td>
                    <td align="center">修  改</td>
                    <td align="center">删  除</td>
                </tr>
                <%
                    List<DetailClass> list = classes.getList();
                    for(int i = 0 ;i < 10 ;i ++){
                        if(i < list.size()){
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                            String time = format.format(list.get(i).getStart());
                %>
                <tr>
                    <td align="center"><%=list.get(i).getCno()%></td>
                    <td align="center"><%=list.get(i).getCname()%></td>
                    <td align="center"><%=list.get(i).getCredit()%></td>
                    <td align="center"><%=list.get(i).getAddress()%></td>
                    <td align="center"><%=time%></td>
                    <td align="center"><%=list.get(i).getDuration()%></td>
                    <td align="center"><%=list.get(i).getTno()%></td>
                    <td align="center"><%=list.get(i).getTname()%></td>
                    <td align="center"><%=list.get(i).getSex()%></td>
                    <td align="center">
                        <a href="../admin/admin_class_update.jsp?clzno=<%=list.get(i).getClzno()%>&start=<%=list.get(i).getStart()%>&address=<%=list.get(i).getAddress()%>&cno=<%=list.get(i).getCno()%>&cname=<%=list.get(i).getCname()%>&credit=<%=list.get(i).getCredit()%>&duration=<%=list.get(i).getDuration()%>&tno=<%=list.get(i).getTno()%>&tname=<%=list.get(i).getTname()%>&sex=<%=list.get(i).getSex()%>">修改</a>
                    </td>
                    <td align="center">
                        <a href="../../servlet/admin/ClassDeleteServlet?clzno=<%=list.get(i).getClzno()%>">删除</a>
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
