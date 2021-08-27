<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/6/8
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/springMVC/hello/save" method="post">
        用户ID：<input type="text" name="id"><br>
        用户名：<input type="text" name="name"><br>
        <%--在针对一个类中引入另一个类作为该类的级联对象，像这种属性值的赋值，需要使用：对象名.属性名 进行赋值--%>
        用户地址：<input type="text" name="address.value"><br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
