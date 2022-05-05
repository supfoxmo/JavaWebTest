<%@page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>增添页面</title>
</head>
<body>
    <h2 align="center">增添页面</h2>
    <hr>
    <form action="<%=request.getContextPath()%>/add" method="post">
        部门编号:<input type="text" name="deptno"/><br>
        部门名称:<input type="text" name="dname"/><br>
        部门地址:<input type="text" name="address"/><br>
        员工人数:<input type="text" name="enums"/><br>
        平均工资:<input type="text" name="wages"/><br>
        <input type="submit" value="提交">
        <input type="reset" value="清空">
    </form>
</body>
</html>