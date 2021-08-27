<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/7/14
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用自定义转换器，用户输入学生信息，转换成学生对象</title>
</head>
<body>
<form action="/springMVC/converter/student" method="post">
    请输入学生信息:<input type="text" name="student">(格式为"1-杨涵琪-18")<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
