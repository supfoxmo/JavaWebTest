<%@ page import="com.java.bean.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String[] userNames = {"zhangsan","lisi","wangwu"};
    
    request.setAttribute("nameArray",userNames);

    User user1 = new User();
    user1.setUserName("joker");
    user1.setPassword("123");
    User user2 = new User();
    user2.setUserName("mark");
    user2.setPassword("456");
    User user3 = new User();
    user3.setUserName("Jorry");
    user3.setPassword("789");

    User[] users = {user1,user2,user3};
    request.setAttribute("userArray",users);

    List<String> str = new ArrayList<>();
    str.add("a");
    str.add("b");
    str.add("c");
    request.setAttribute("str",str);

    Map<String, String> map = new HashMap<>();
    map.put("username","zhangsan");
    map.put("password","123456");
    request.setAttribute("userMap",map);

%>

<%--使用El表达式取出数组中的元素--%>

${nameArray[0]}<br>
${nameArray[1]}<br>
${nameArray[2]}<br>
<%--若下表越界，El表达式将会把空字符串发送给浏览器--%>
${nameArray[100]}<br>

${userArray[0].userName}<br>
${userArray[0].password}<br>
${userArray[1].userName}<br>
${userArray[1].password}<br>
${userArray[2].userName}<br>
${userArray[2].password}<br>
<%--List集合--%>
<hr>
list集合<br>
${str[0]}
${str[1]}
${str[2]}
<%--Map集合--%>
<hr>
Map集合<br>
${userMap.username}<br>
${userMap.password}<br>