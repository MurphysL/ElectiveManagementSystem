
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="login">
    <div id="login_info">
        <img class="cancel" src="../../img/cancel.png" onclick="back()">
        <form name="form" method="post" action="../../servlet/LoginServlet" onsubmit="return check()">
            <input class="form_input" type="text" name="no" placeholder="学   号/教工号/管理员号"><br>
            <input class="form_input" type="password" name="password" placeholder="密    码"><br>
            <select class="form_input" name="type">
                <option value="student">学&nbsp;&nbsp;&nbsp;生</option>
                <option value="teacher">教&nbsp;&nbsp;&nbsp;师</option>
                <option value="admin">管理员</option>
            </select><br>
            <input class = "form_bt" type="submit" value="确认">
            <input class = "form_bt" type="reset" value="重置">
        </form>
    </div>
</div>
