<%@ page import="com.java.bean.User" %>
<%@ page import="com.java.bean.Address" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setAttribute("username","zhangsan");

    User user = new User();
    user.setUserId("1001");
    user.setUserName("zhangsan");
    user.setPassword("123456");

    Address address = new Address("广州市", "仲恺路");
    user.setAddress(address);

    request.setAttribute("userobj",user);
%>

<%--取出请求域的数据 方式一：--%>
<%=request.getAttribute("username")%><br>
<%--方式二：EL表达式--%>
<%--EL表达式的三大功能：
        1.从某个域中取数据
        2.将取出来的数据转成字符串
        3.将字符串输出到浏览器
    ****EL表达式主要和get方法有关

    --%>
${username}<br>

${userobj}<br>

${userobj.userName}<br><%--相当于${userobj.getuserName()}--%>
${userobj["userName"]}<br>
${userobj.address.city}<br><%--相当于${userobj.getAddress().getCity()}--%>