<%--
  Created by IntelliJ IDEA.
  User: li'xiao'hui
  Date: 2022/3/16
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基本函数</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#btn1").click(function (){
                alert($(":text").val());
            })

            $("#btn2").click(function (){
                $(":text").val("三国演义");
            })

            $("#btn3").click(function (){
                //将数组中所有的Dom对象的文本组合成一个字符串
                alert($("div").text());//第一个div-1第二个div-2第三个div-3
            })

            $("#btn4").click(function (){
                $("div").text("div的新值")
            })

            $("#btn5").click(function (){
                $("a").attr("href","http://www.jd.com");
                $("a").text("京东");
            })

            $("#btn6").click(function (){
                alert($("a").attr("href"));
            })
        })
    </script>
</head>
<body>
    <input type="text" id="txt1" value="刘备"/><br>
    <input type="text" id="txt2" value="关羽"/><br>
    <input type="text" id="txt3" value="张飞"/><br>

    <br>
    <div>第一个div-1</div><br>
    <div>第二个div-2</div><br>
    <div>第三个div-3</div><br>

    <a href="https://www.baidu.com">百度</a><br><br>
<%--    <a href="http://www.jd.com">京东</a>--%>
<%--    <a href="http://www.hao123.com">hao123</a><br><br>--%>

    <input type="button" id="btn1" value="获取第一个文本框的值"/><br>
    <input type="button" id="btn2" value="设置所有文本框的新值"/><br>
    <input type="button" id="btn3" value="获取div的所有文本"/><br>
    <input type="button" id="btn4" value="设置div新文本"/><br>
    <input type="button" id="btn5" value="修改超链接路径"/><br>
    <input type="button" id="btn6" value="读取超链接的路径"/><br>
</body>
</html>
