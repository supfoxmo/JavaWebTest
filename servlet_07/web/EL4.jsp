<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--在El表达式中市没有除了pageContext的其他JSP九大内置对象
    但可以通过pageContext获取到其他内置对象--%>

<%=request.getContextPath()%><br>
<%--等同于--%>
${pageContext.request.contextPath}