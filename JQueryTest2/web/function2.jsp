<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基本函数(2)</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#btn1").click(function (){
                alert($("#sanguo>#op1").text());//刘备
                alert($("select>option").text());//刘备关羽张飞广州深圳北京
            })

            $("#btn2").click(function (){
                $("select").empty();
            })

            $("#btn3").click(function (){
                $("select").remove();
            })

            $("#btn4").click(function (){
                $("div").append("<input type='button' value='div的按钮'/>");
            })

            $("#btn5").click(function (){
                alert($("span").html());//我是一个MySQL<b>数据库</b>
                alert($("span:first").text());//我是一个MySQL数据库
            })

            $("#btn6").click(function (){
                $("span:last").html("我是<b>JDBC</b>接口");
            })
        })
    </script>
</head>
<body>
    <select id="sanguo">
        <option id="op1" value="op1">刘备</option>
        <option value="op2">关羽</option>
        <option value="op3">张飞</option>
    </select>
    <select id="city">
        <option value="op1">广州</option>
        <option value="op2">深圳</option>
        <option value="op3">北京</option>
    </select>
    <br><br>
    <div>第一个div-1</div>
    <br><br>
    <span>我是一个MySQL<b>数据库</b></span><br>
    <span>我是JDBC接口</span>
    <br><br>
    <input type="button" id="btn1" value="获取下拉框的文本框"/><br>
    <input type="button" id="btn2" value="删除所有select的子对象"/><br>
    <input type="button" id="btn3" value="删除所有select对象包括其子对象"/><br>
    <input type="button" id="btn4" value="使用append，增加Dom对象"/><br>
    <input type="button" id="btn5" value="获取文本中有html标签的内容"/><br>
    <input type="button" id="btn6" value="设置文本内容，其中带有html标签"/>

</body>
</html>
