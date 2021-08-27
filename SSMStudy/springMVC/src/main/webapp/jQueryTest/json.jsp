<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/6/9
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--
    引入jquery配置文件

    注意：！！下面的书写格式不可以换，且必须引入相关的依赖（三个依赖）
        否则！！！！在json数据回传至客户端的时候会报一个415错误。。。。劳资改了一天。。。。。。切记切记！！！！
    --%>
    <script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        $(function(){
            var user={
                "id":1,
                "name":"张三",
                "address":null
            };
            $.ajax({
                url:"/springMVC/data/json",   //在浏览器解析的时候，/表示的意思只有"http://localhost:8080/"没有工程名
                data:JSON.stringify(user),
                type:"POST",
                contentType:"application/json;charset=UTF-8",//处理中文乱码问题，以json的形式
                dataType:"JSON",
                success:function (data) {
                    alert(data.id+"-----"+data.name);
                }
            })
        });
    </script>
</head>
<body>

</body>
</html>
