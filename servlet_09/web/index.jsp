<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>通过ID查询省份</title>

    <script type="text/javascript">
      var province = function (){
        //创建异步对象
        var xmlHttp = new XMLHttpRequest();
        //绑定事件
        xmlHttp.onreadystatechange = function (){
          if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
            document.getElementById("pname").value = xmlHttp.responseText;
          }
        }
        //初始化异步对象的请求数据
        var proId = document.getElementById("pid").value;
        xmlHttp.open("get","/servlet_09/province?proId=" + proId,true);
        //发送请求
        xmlHttp.send();
      }

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
          <input type="button" value="搜索" onclick="province()"/>
        </td>
      </tr>
      <tr>
        <td>
          省份名称：<input type="text" id="pname"/>
        </td>
      </tr>
    </table>
  </body>
</html>
