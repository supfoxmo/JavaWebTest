<%@ page import="com.java.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>JSTL标签库测试</title>
    <%
        Student student1 = new Student("zhangsan",17,"男");
        Student student2 = new Student("lisi",25,"女");
        Student student3 = new Student("wangwu",45,"男");
        Student student4 = new Student("zhaoliu",60,"女");

        List<Student> studentList = new ArrayList<>();

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        //将集合存储到请求域中
        request.setAttribute("students",studentList);
    %>
</head>
<body>
    <h2>JSTL标签库测试</h2>
    <hr>
    <%----%>
    <c:forEach var="i" begin="1" end="10" step="1">
        ${i}
    </c:forEach>
</body>
</html>
