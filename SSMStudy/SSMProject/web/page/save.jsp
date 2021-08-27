<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/8/11
  Time: 17:07
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
<form action="/SSMProject/book/save" method="post">
    <table>
        <tr>
            <td>图书编号</td>
            <td>
                <input type="text" name="id">
            </td>
        </tr>
        <tr>
            <td>图书名称</td>
            <td>
                <input type="text" name="bookname">
            </td>
        </tr>
        <tr>
            <td>图书价格</td>
            <td>
                <input type="text" name="bookprice">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
            <td>
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
