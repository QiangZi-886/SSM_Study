<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/6/9
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>给Map集合赋值</title>
</head>
<body>
    <form action="data/map" method="post">
        用户1编号：<input type="text" name="users['a'].id"><br>
        用户1姓名：<input type="text" name="users['a'].name"><br>
        用户2编号：<input type="text" name="users['b'].id"><br>
        用户2姓名：<input type="text" name="users['b'].name"><br>
        用户3姓名：<input type="text" name="users['c'].id"><br>
        用户3姓名：<input type="text" name="users['c'].name"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
