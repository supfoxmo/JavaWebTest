<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>省份信息的级联查询</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
      function doQuery(){
        $.ajax({
          url : "proQueryTest",
          dataType: "json",
          success : function (responseText){
            // 清空旧数据
            $("#province").empty();
            $.each(responseText,function (i,json){
              // 增添新数据
              $("#province").append("<option value='"+ json.pid +"'>"+ json.pname +"</option>");
            })
          }
        })
      }

      function doCityQuery(responseText){
        $("#city").empty();
        $.each(responseText,function (i,json){
          $("#city").append("<option value='"+ json.cid +"'>"+ json.cname +"</option>");
        })
      }


      $(function (){
        doQuery();

        $("#btn1").click(function (){
          doQuery();
        })

        $("#province").change(function (){
          var pid = $("#province>option:selected").val();
          // $.ajax({
          //   url : "cityQueryTest",
          //   data : pid,
          //   dataType : "json",
          //   success : function (responseText){
          //     $("#city").empty();
          //     $.each(responseText,function (i,json){
          //       $("#city").append("<option value='"+ json.cid +"'>"+ json.cname +"</option>");
          //     })
          //   }
          // })

          $.get("cityQueryTest",{"pid":pid},function (responseText){
            $("#city").empty();
            $.each(responseText,function (i,json){
              $("#city").append("<option value='"+ json.cid +"'>"+ json.cname +"</option>");
            })
          },"json")
        })
      })
    </script>
  </head>
  <body>
  <h1 >省份信息的级联查询</h1>
  <hr>
  <table>
    <tr>
      <td>省份名称：</td>
      <td>
        <select id="province">
          <option>请选择。。。</option>
        </select>
        <input type="button" id="btn1" value="load。。。"/>
      </td>
    </tr>
    <tr>
      <td>城市名称：</td>
      <td>
        <select id="city">
          <option>请选择。。。</option>
        </select>
      </td>
    </tr>
  </table>
  </body>
</html>
