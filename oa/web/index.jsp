<%@page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>
<body>
    <h1 align="center">登录页面</h1>
    <hr>
    <form action="<%=request.getContextPath()%>/login" method="post">
        用户名:<input type="text" name="username"/><br>
        密码 :<input type="text" name="password"/><br>
        <input type="checkbox" name="sign" value="1"> 十天内免登录</input><br>
        <input type="submit" value="登录"/><br>
        如果没有账户，请先<a href="<%=request.getContextPath()%>/register.jsp">注册账户</a>

    </form>
</body>
</html>