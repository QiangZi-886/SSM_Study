<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/7/19
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%--这里的prefix前缀可以自定义，一般都定义为form--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>使用表单标签库</h1>
    <form:form modelAttribute="student">    <%--将整个form表单与TagHandler中的attribute的student绑定--%>
        学生ID:<form:input path="id"></form:input><br>    <%--绑定好模型数据中的student之后，在form的input中直接使用path获取即可--%>
        学生姓名:<form:input path="name"></form:input><br>
        学生年龄:<form:input path="age"></form:input><br>
        checkbox:<form:checkbox path="flag"></form:checkbox><br>
<%--        爱好:<form:checkbox path="hobby" value="学习"/>学习<br>
        <form:checkbox path="hobby" value="睡觉"/>睡觉<br>
        <form:checkbox path="hobby" value="看电影"/>看电影<br>
        <form:checkbox path="hobby" value="发呆"/>发呆<br>
        <form:checkbox path="hobby" value="玩游戏"/>玩游戏<br>
        <form:checkbox path="hobby" value="看手机"/>看手机<br>--%>
        <%--前台简化写法，使用form标签里的checkboxes属性，其中path绑定被选中的数组/集合，items绑定被遍历的数组或集合（可以这样理解
        path为默认选中的数组/集合，items为全部可选集合）--%>
        爱好:<form:checkboxes path="selectHobby" items="${student.hobby}"></form:checkboxes><br>
        <%--注意：path可以直接绑定模型数据的属性值，items只能通过EL表达式从域中获取数据，不能直接写属性名--%>

        RadioIdButton:<form:radiobutton path="radioId" value="1"/>radiobutton<br>
        学生年级:<form:radiobuttons path="selectGrade" items="${student.gradeMap}"/><br>

        所在城市:<form:select path="selectCity" items="${student.cityMap}"/><br>
        <%--select结合option的使用--%>
        所在城市:<form:select path="selectCity"><%--这里报的这个错不影响--%>
                    <form:options items="${student.cityMap}"></form:options><br>
                </form:select>
        <%--将后台可选城市的范围设置在前台jsp页面--%>
        所在城市:<form:select path="selectCity">
                    <form:option value="1">信阳</form:option>
                    <form:option value="2">潢川</form:option>
                    <form:option value="3">桃林</form:option>
                    <form:option value="4">香铺</form:option>
                </form:select><br>
        信息:<form:textarea path="introduce"/><br>
        <input type="submit" value="提交">
    </form:form>
</body>
</html>
