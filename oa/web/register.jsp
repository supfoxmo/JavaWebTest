<%--
  Created by IntelliJ IDEA.
  User: li'xiao'hui
  Date: 2022/3/12
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<h1 align="center">注册页面</h1>
<hr>
<form action="<%=request.getContextPath()%>/register" method="post">
    用户名:<input type="text" name="username"/><br>
    密码 :<input type="text" name="password"/><br>
    <input type="submit" value="注册"/><br>
</form>
</body>
</html>
