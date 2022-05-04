<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基本选择器</title>
    <style type="text/css">
        /*!*id样式*!
        #joker {
            background: burlywood;
            width: 250px;
            height: 50px;
        }
        !*class样式*!
        .divclas {
            background: blue;
            width: 300px;
            height: 50px;
        }*/
        /*标签样式*/
        div {
            background: chartreuse;
            width: 200px;
            height: 50px;
        }

    </style>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

    <script >
        var func1 = function(){
            //id选择器
            var $div1 = $("#joker");
            $div1.css("background","red");
            $div1.css("width","250px");
            $div1.css("height","50px");
        }

        var func2 = function(){
            //.class样式选择器
            var $div1 = $(".divclass");
            $div1.css("background","burlywood");
            $div1.css("width","300px");
            $div1.css("height","50px");
        }
        var func3 = function(){
            //标签选择器
            var $div1 = $("div");
            $div1.css("background","blue");
            $div1.css("width","350px");
            $div1.css("height","50px");
        }
        var func4 = function(){
            //组合选择器
            var $div1 = $("#joker,#text1,#text3");
            $div1.css("background","black");
        }

        var func5 = function(){
            //所有选择器
            var $div1 = $("*");
            $div1.css("background","yellow");
        }

    </script>
</head>
<body>
    <h2>基本选择器</h2>
    <hr>
    <div id="joker">我是joker的div</div>
    <hr>
    <div id="mike">我是mike的div</div>
    <hr>
    <div id="jerry"  class="divclass">我是id :jerry / class:div 的div</div>
    <hr>

    <input type="text" id="text1" value="我是text1的input"/>
    <input type="text" id="text2" value="我是text2的input"/>
    <input type="text" id="text3" value="我是text3的input"/><br>

    <input type="button" value="id选择器" onclick="func1()"/>
    <input type="button" value=".class样式选择器" onclick="func2()"/>
    <input type="button" value="标签选择器" onclick="func3()"/>
    <input type="button" value="组合选择器" onclick="func4()"/>
    <input type="button" value="所有选择器" onclick="func5()"/>
</body>
</html>
