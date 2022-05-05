<%@ page import="java.util.List" %>
<%@ page import="com.java.bean.Dept" %>
<%@ page import="com.java.bean.Dept" %>
<%--
  Created by IntelliJ IDEA.
  User: li'xiao'hui
  Date: 2022/3/11
  Time: 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>列表页面</title>
<%--设置整个网页的基础路径--%>
<%--    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.CpntextPath}/"/>--%>

    <script type="text/javascript">
    function del(deptno){
        if (window.confirm("亲，确认删除该数据吗？")){
        document.location.href = "<%=request.getContextPath()%>/delete?deptno="+deptno }
    }
    </script>
</head>
<body>
    <h2 align="center">列表页面</h2>
    <hr>
    <table border="1px" align="center" width="40%">
        <tr>
            <th>序号</th>
            <th>部门编号</th>
            <th>部门名称</th>
            <th>操作</th>
        </tr>

        <%
            List<Dept> deptList = (List<Dept>)request.getAttribute("deptList");

            int i = 0;

            for(Dept dept:deptList) {
        %>

        <tr>
            <td><%=++i%></td>
            <td><%=dept.getDeptno()%></td>
            <td><%=dept.getDname()%></td>
            <td>
                <a href="javascript:void(0)" onclick="del(<%=dept.getDeptno()%>)">删除</a>
                <a href="<%=request.getContextPath()%>/edit.jsp?deptno=<%=dept.getDeptno()%>&dname=<%=dept.getDname()%>&address=<%=dept.getAddress()%>&enums=<%=dept.getEnums()%>&wages=<%=dept.getWages()%>">修改</a>
                <a href="<%=request.getContextPath()%>/detail?deptno=<%=dept.getDeptno()%>">详情</a>
            </td>
        </tr>

        <%
            }
        %>

    </table>
    <a href="<%=request.getContextPath()%>/add.jsp">新增部门信息</a><br><br>
    <a href="<%=request.getContextPath()%>/exit">[退出系统]</a>
</body>
</html>
