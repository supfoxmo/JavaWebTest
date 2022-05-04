<%--
  Created by IntelliJ IDEA.
  User: li'xiao'hui
  Date: 2022/3/15
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单选择器</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        var fun1 = function (){
            //表单选择器，获取text的jQuery对象(Dom对象转化为jQuery对象)
            var $text = $(":text");
            //通过jQuery对象的.val()方法获取value
            alert($text.val());
        }

        var fun2 = function (){
            //所有jQuery对象的是数组，数组的中的元素都为Dom对象
            var $radio = $(":radio");
            for (var i = 0; i < $radio.length; i++) {
                //jQuery对象转化为Dom对象
                var radioElement = $radio[i];
                //通过Dom对象的value属性获取value
                alert(radioElement.value);
            }
        }

        var fun3 = function (){
            var $checkbox = $(":checkbox");
            for (var i = 0; i < $checkbox.length; i++) {
                var checkboxElement = $checkbox[i];
                var $checkboxElement = $(checkboxElement);
                alert($checkboxElement.val())
            }
        }
    </script>
</head>
    <h2>表单选择器</h2>
    <hr>

    <input type="text" value="我是一个文本框"/><br>

    <input type="radio" value="man" checked="false"/>男<br>
    <input type="radio" value="weman"/>女<br>

    <input type="checkbox" value="playgame">游戏</input><br>
    <input type="checkbox" value="swim">游泳</input><br>
    <input type="checkbox" value="work">工作</input><br>

    <input type="button" value="获取文本框中的value" onclick="fun1()"/>
    <input type="button" value="获取radio中的value" onclick="fun2()"/>
    <input type="button" value="获取checkbox中的value" onclick="fun3()"/>
</body>
</html>
