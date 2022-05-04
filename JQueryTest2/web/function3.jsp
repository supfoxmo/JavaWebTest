<%--
  Created by IntelliJ IDEA.
  User: li'xiao'hui
  Date: 2022/3/16
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>each循环函数</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#btn1").click(function (){
                var array = [1,2,3,4,5];
                //方式一
                $.each(array,function (i,element){
                    alert(i + "---->" + element);
                })
                //方式二
                // $(array).each(function (i,element){
                //     alert(i + "---->" + element);
                // })
            })

            $("#btn2").click(function (){
                var json = {"name":"zhangsan","sno":1001,"age":21,"sex":"男"};
                $.each(json,function (key,value){
                    alert(key + "==" + value);
                })
            })

            $("#btn3").click(function (){
                //方式一
                $.each($(":text"),function (i,dom){
                    alert(i + "---->" + dom.value);
                })
                //方式二
                // $(":text").each(function (i,dom){
                //     alert(i + "---->" + dom.value);
                // })
            })
        })
    </script>
</head>
<body>
    <input type="text" value="刘备"/><br>
    <input type="text" value="关羽"/><br>
    <input type="text" value="张飞"/><br><br>

    <input type="button" id="btn1" value="循环普通数组"/><br>
    <input type="button" id="btn2" value="循环Json"/><br>
    <input type="button" id="btn3" value="循环Dom数组(JQuery对象)"/><br>
</body>
</html>
