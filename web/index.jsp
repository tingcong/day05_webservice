<%--
  Created by IntelliJ IDEA.
  User: 聪
  Date: 2017/4/18
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
  </head>
  <body>
  <select id="province">
    <option value="31124">广东省</option>
  </select>
  <select id="city">
    <option value="2350">广州</option>
    <option value="2419">深圳</option>
    <option value="2351">东莞</option>
  </select>
  <hr/>
  <span>XXXX</span>
  <script type="text/javascript">
      $("#city").change(function(){
          var city=$("#city option:selected").val();
          $.post("weatherServlet",{"city":city},function(backdata){
              $("span").text(backdata).css("color","blue");
          });
      });
  </script>
  </body>
</html>
