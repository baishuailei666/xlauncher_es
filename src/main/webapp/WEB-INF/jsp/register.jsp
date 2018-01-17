<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/8 0008
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>

<html>
<head>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>注册测试</title>
    </head>
</head>
<body>
<jsp:useBean id="user" scope="page" class="ssm.model.RegisterBean"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
注册成功：<br>
使用Bean属性方法：
<br>
Name：<%=user.getName() %>
<br>
Age：<%=user.getAge() %>
<br>
<h2>Goooooo</h2>
</body>
</html>
