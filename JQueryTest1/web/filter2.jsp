<%--
  Created by IntelliJ IDEA.
  User: li'xiao'hui
  Date: 2022/3/16
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单属性过滤器</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#btn1").click(function (){
                $(":text:enabled").val("Hello");
            })

            $("#btn2").click(function (){
                var $checkbox = $(":checkbox:checked");
                for (var i = 0; i < $checkbox.length; i++) {
                    alert($checkbox[i].value);
                }
            })

            $("#btn3").click(function (){
                alert($("select>option:selected").val())
            })
        })

    </script>
</head>
<body>
    <h2>表单属性过滤器</h2>
    <hr>
    <input type="text" id="txt1" value="text1"/><br>
    <input type="text" id="txt2" value="text2" disabled="true"/><br>
    <input type="text" id="txt3" value="text3"/><br>
    <input type="text" id="txt4" value="text4" disabled/><br>

    <br>
    <input type="checkbox" value="旅游">旅游</input><br>
    <input type="checkbox" value="工作" checked>工作</input><br>
    <input type="checkbox" value="上学" checked>上学</input><br>
    <br>
    <select id="sel">
        <option >JAVA语言</option>
        <option selected>C++语言</option>
        <option>Python语言</option>
    </select>
    <br><br>
    <input type="button" id="btn1" value="所有可用的text设置为Hello"/><br>
    <input type="button" id="btn2" value="显示被选中的复选框的值"/><br>
    <input type="button" id="btn3" value="显示下拉列表选中的值"/><br>
</body>
</html>
