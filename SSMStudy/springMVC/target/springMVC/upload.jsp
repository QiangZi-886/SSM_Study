<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/7/17
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>单文件上传</title>
</head>
<body>
<form action="/springMVC/file/upload" method="post" enctype="multipart/form-data">    <%--method属性和enctype标签值必须是这两个--%>
    <input type="file" name="img"/><br>
    <input type="submit" value="上传">
</form>
<img src="${path}"><%--使用EL表达式直接从request域中获取path的值（路径）即可，但是图片是静态资源无法加载，需要去web.xml中添加相关配置--%>
</body>
</html>
