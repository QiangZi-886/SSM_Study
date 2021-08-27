<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/8/11
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="index.jsp" method="get">
        <c:if test="${book!=null}">
            您查询的书为:${book}
        </c:if>
        <c:if test="${book == null}">
            查无此书
        </c:if>
        <input type="submit" value="返回首页">
    </form>
</body>
</html>
