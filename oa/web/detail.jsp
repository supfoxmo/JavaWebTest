<%@ page import="com.java.bean.Dept" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: li'xiao'hui
  Date: 2022/3/11
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>详情页面</title>
</head>
<body>
    <h2 align="center">详情页面</h2>
    <hr>
    <table border="1px" align="center" width="40%">
        <tr>
            <th>部门编号</th>
            <th>部门名称</th>
            <th>部门地址</th>
            <th>员工人数</th>
            <th>平均工资</th>
        </tr>

        <%
            List<Dept> deptDetail = (List<Dept>)request.getAttribute("deptDetail");

            int i = 0;

            for(Dept dept:deptDetail) {
        %>

        <tr>
            <td><%=dept.getDeptno()%></td>
            <td><%=dept.getDname()%></td>
            <td><%=dept.getAddress()%></td>
            <td><%=dept.getEnums()%></td>
            <td><%=dept.getWages()%></td>
        </tr>

        <%
            }
        %>
    </table>
    <input type="button" value="返回部门列表页面" onclick="window.history.back()"></input>
</body>
</html>