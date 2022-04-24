<%--
  Created by IntelliJ IDEA.
  User: li'xiao'hui
  Date: 2022/3/12
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Session Test</title>
  </head>
  <body>
    <a href="<%=request.getContextPath()%>/test/session">Session Test</a><br>
    <a href="<%=request.getContextPath()%>/send/cookie">Cookie Generate</a><br>
    <a href="<%=request.getContextPath()%>/get/cookie">Cookie </a><br>
    <a href="<%=request.getContextPath()%>/EL.jsp">EL test</a><br>
    <a href="<%=request.getContextPath()%>/EL2.jsp">EL2 test</a><br>
    <a href="<%=request.getContextPath()%>/EL3.jsp">EL3 test</a><br>
    <a href="<%=request.getContextPath()%>/EL4.jsp">EL4 test</a><br>
    <a href="<%=request.getContextPath()%>/jstl.jsp">JSTL test</a><br>
  </body>
</html>
