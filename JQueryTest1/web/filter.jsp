<%--
  Created by IntelliJ IDEA.
  User: li'xiao'hui
  Date: 2022/3/15
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基本过滤器</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        //相当于window.onload,当页面加载完后执行以下函数
        $(function (){
            $("#btn1").click(
                function (){
                    //过滤器，获取第一个jQuery对象
                    var $div = $("div:first");
                    $div.css("background","blue");
                }
            )

            $("#btn2").click(
                function (){
                    //过滤器，获取最后一个jQuery对象
                    var $div = $("div:last");
                    $div.css("background","red");
                }
            )

            $("#btn3").click(
                function (){
                    //过滤器，获取第三个jQuery对象
                    var $div = $("div:eq(2)");
                    $div.css("background","orange");
                }
            )

            $("#btn4").click(
                function (){
                    //过滤器，获取前三个jQuery对象
                    var $div = $("div:lt(3)");
                    $div.css("background","yellow");
                }
            )

            $("#btn5").click(
                function (){
                    //过滤器，获取倒数三个jQuery对象
                    var $div = $("div:gt(3)");
                    $div.css("background","pink");
                }
            )
        })

    </script>
</head>
<body>
    <h2>基本过滤器</h2>
    <hr>
    <div>第一个div-0</div>
    <div>第二个div-1</div>
    <div>第三个div-2
        <div>第四个div-3</div>
        <div>第五个div-4</div>
    </div>
    <div>第六个div-5</div>

    <input type="button" id="btn1" value="获取第一个div"/><br>
    <input type="button" id="btn2" value="获取最后个div"/><br>
    <input type="button" id="btn3" value="获取第三个div"/><br>
    <input type="button" id="btn4" value="获取前三个div"/><br>
    <input type="button" id="btn5" value="获取倒数三个div"/><br>
</body>
</html>
