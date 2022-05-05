<%@page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改页面</title>
</head>
<body>
    <h2 align="center">修改页面</h2>
    <hr>

    <%
        //获取修改前的部门信息
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String address = request.getParameter("address");
        String enums = request.getParameter("enums");
        String wages = request.getParameter("wages");
    %>

    <form action="<%=request.getContextPath()%>/edit" method="post">
        部门编号:<input type="text" value=<%=deptno%> name="deptno" readonly /><br>
        部门名称:<input type="text" value=<%=dname%> name="dname" /><br>
        部门地址:<input type="text" value=<%=address%> name="address" /><br>
        员工人数:<input type="text" value=<%=enums%> name="enums" /><br>
        平均工资:<input type="text" value=<%=wages%> name="wages" /><br>
        <input type="submit" value="提交">
        <input type="reset" value="清空">
    </form>
</body>
</html>