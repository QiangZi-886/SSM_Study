<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/7/19
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form modelAttribute="account" action="/springMVC/validator/login" method="post">
        姓名:<form:input path="name"/><for:errors path="name"/><br>
        密码:<form:input path="password"/><form:errors path="password"/><br>
        <input type="submit" value="提交">
    </form:form>
</body>
</html>
