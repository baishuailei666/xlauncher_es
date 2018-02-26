<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/4 0004
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>

<%@ page pageEncoding="UTF-8" language="java" import="java.util.*"  %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head><
    <base href="<%=basePath%>">
    <style type="text/css">
        form{
            margin: 0px auto;

            width: 500px;
            padding: 20px;
        }
    </style>
    <title>欢迎欢迎</title>
</head>

<body>
<h2>Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello  You</h2>
    <form action="save" method="post">
        姓名：<input type="text" name="name"/><br/>
        年龄：<input type="text" name="age"/><br/>
        性别：<input type="text" name="sex"/><br/>
        住址：<input type="text" name="address"/><br/>
        工资：<input type="text" name="money"/><br/>
        时间：<input type="text" name="time"/><br/>
        运动：<input type="text" name="sport"/><br><br>


        <input type="submit" value="戳我"/>
        <input type="button" name="jump" onclick="window.location.href='getAllUsers';"value="跳过"/>
    </form>
</body>
</html>
