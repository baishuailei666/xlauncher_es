<%@ page language="java" import="java.util.*" import="LoginAuth.Token" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>登录</title>

    <style type="text/css">
        form{
            margin: 0px auto;

            width: 500px;
            padding: 20px;
        }
    </style>

</head>

<body>
<form action="/users/login" method="post">
    用户名:<input type="text" name="userName" /><br/><br/>
    密  码:<input type="text" name="passWord" /><br/><br/>
    <input type="submit" value="登录" />
    <input type="text" id="a1">
    <input type="text" id="a2">
</form>
</body>
</html>
<script>
    var a1 = documnet.getElementById('a1').value;
    var a2 = documnet.getElementById('a2').value;
    var json = {'userName':a1,'passWord':a2};

</script>
