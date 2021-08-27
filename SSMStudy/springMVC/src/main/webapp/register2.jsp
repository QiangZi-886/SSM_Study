<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/7/19
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Annotation JSR-303测试</title>
</head>
<body>
    <form:form modelAttribute="person" action="/springMVC/validator/register2" method="post">
        用户名:<form:input path="username"/><form:errors path="username"/><br>
        密码:<for:password path="password"/><form:errors path="password"/><br>
        电子邮箱:<form:input path="email"/><form:errors path="email"/><br>
        手机号:<form:input path="phone"/><form:errors path="phone"/><br>
        <input type="submit" value="提交">
    </form:form>
</body>
</html>
