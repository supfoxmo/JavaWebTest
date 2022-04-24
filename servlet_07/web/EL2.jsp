<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    pageContext.setAttribute("date","pageContext");
    request.setAttribute("date","request");
    session.setAttribute("date","session");
    application.setAttribute("date","application");
%>
<%--若各个域中有相同name的数据，EL表达式优先从小范围中取数据--%>
${date}<br><%--pageContext--%>

<%--El表达式中有四个隐含的隐式范围--%>
${pageScope.date}<br>
${requestScope.date}<br>
${sessionScope.date}<br>
${applicationScope.date}<br>

<%--El表达式对null进行了预处理，如果市null，则返回空字符串给浏览器--%>
<%=request.getAttribute("abc")%><%--null--%>
${abc}<%--""--%>
