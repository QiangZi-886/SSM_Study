<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/7/13
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${requestScope.user}
    <HR>
    ${sessionScope.user}
    <hr>
    ${applicationScope.user}
</body>
</html>
