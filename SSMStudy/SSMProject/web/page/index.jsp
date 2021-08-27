<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/8/10
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>简单的测试继承框架 操作数据库</title>
</head>
<body>
<%--  <c:forEach items="${books}" var="book">
    ${book.id}-------${book.bookname}-------${book.bookprice}￥<br>
  </c:forEach>--%>
<style>
    .table {
        border: 1px solid #000000;
        border-collapse: collapse;
        width:500px;
        height: 1000px;
    }

    .table th {
        border: 1px solid #000000;
        border-collapse: collapse;
    }

    .table td {
        border: 1px solid #000000;
        border-collapse: collapse;
    }
</style>
<div style="height:600px;width: 500px;overflow-y: scroll;text-align: center;margin: 0 auto;">
    <table class="table" align="center" cellpadding="10">
        <tr>
            <th>编号</th>
            <th>书名</th>
            <th>价格</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.bookname}</td>
                <td>${book.bookprice}</td>
                <td>
                    <form action="/SSMProject/book/deleteById/${book.id}" method="post">
                        <input type="hidden" name="_method" value="DELETE">
                        <input type="submit" value="删除">
                    </form>
                    <a href="/SSMProject/book/findById/${book.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<a href="http://localhost:8080/SSMProject/page/save.jsp" style="text-align: center">添加书籍</a>
<%--<a href="http://localhost:8080/SSMProject/page/update.jsp">更新书籍</a>--%>

</body>
</html>
