<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>局部更新——Ajax</title>
    <script type="text/javascript">
      var doAjax = function(){
        //1.创建异步对象
        var xmlHttp = new XMLHttpRequest();
        //2.绑定事件
        xmlHttp.onreadystatechange = function (){
          //处理服务器返回的数据，更新当前页面
          if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
            // //将服务器返回的数据输出到对话框中
            // alert(xmlHttp.responseText)
            //将服务器返回的数据显示到div中
            document.getElementById("result").innerText = xmlHttp.responseText;
          }
        }
        //获取Dom对象的value值
        var name = document.getElementById("name").value;
        var height = document.getElementById("height").value;
        var weight = document.getElementById("weight").value;

        var param = "?name=" + name + "&height=" + height + "&weight=" + weight;

        //3.初始化异步对象的请求数据
        xmlHttp.open("get","/servlet_8/ajaxServlet" + param,true);
        //4.发送请求
        xmlHttp.send();
      }

    </script>
  </head>
  <body>

    <div>
      姓名:<input type="text" id="name"/><br>
      身高(/m):<input type="text" id="height"/><br>
      体重(/kg):<input type="text" id="weight"/><br>
      <input type="button" value="计算BMI值" onclick="doAjax()"/>
    </div>
    <br><br>
    <div id="result">等待计算结果输出。。。。</div>

  </body>
</html>
