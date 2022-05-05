<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>JQuery_ajax</title>
  <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
  <script type="text/javascript">
    $(function (){
      $("#btn").click(function (){
        //获取省份编号
        var id = $("#pid").val();
        $.ajax({
          //请求路径
          url : "province",
          //请求参数
          data : {"pid" : id},
          //期望从服务器返回的数据格式
          dataType : "json",
          //服务器成功发出响应后，执行以下函数，
          //response:服务器响应的数据
          success : function (responseText){
            // var json = eval(responseText);
            $("#pname").val(responseText.name);
            $("#jiancheng").val(responseText.jiancheng);
            $("#shenghui").val(responseText.shenghui);
          },
          //async:boolean类型，默认值true，表示异步请求（可省略）
          async : true,
          //type:请求类型，默认get类型（可省略）
          //contentType:字符串类型，表示从浏览器发送的参数格式，（可省略）
          contentType : "application/json",
          //error:function类型，表示当请求失败时，执行的函数（可省略）

        })
      })
    })

  </script>
</head>
<body>
<table>
  <tr>
    <th>通过ID查询省份名称</th>
  </tr>
  <tr>
    <td>
      省份编号：<input type="text" id="pid"/>
      <input type="button" id="btn" value="搜索"/>
    </td>
  </tr>
  <tr>
    <td>
      省份名称：<input type="text" id="pname"/>
    </td>
  </tr>
  <tr>
    <td>
      省份简称：<input type="text" id="jiancheng"/>
    </td>
  </tr>
  <tr>
    <td>
      省会名称：<input type="text" id="shenghui"/>
    </td>
  </tr>
</table>
</body>
</html>
