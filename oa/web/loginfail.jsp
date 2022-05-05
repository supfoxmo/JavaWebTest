<%--
  Created by IntelliJ IDEA.
  User: li'xiao'hui
  Date: 2022/3/12
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
</head>
<body>
    <%
        String mode = request.getParameter("m");
        if("l".equals(mode)){
    %>
        登录失败，请<a href="<%=request.getContextPath()%>/index.jsp">重新登录！！！！</a>
    <%
        }else if("r".equals(mode)){
    %>
        注册失败，请<a href="<%=request.getContextPath()%>/register.jsp">重新注册！！！！</a>
    <%
        }
    %>
</body>
</html>
