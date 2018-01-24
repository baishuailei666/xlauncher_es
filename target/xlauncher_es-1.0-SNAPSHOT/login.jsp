<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<form action="${pageContext.request.contextPath}/login.action" method="post">
    用户名:<input type="text" name="username" /><br/><br/>
    密  码:<input type="text" name="password" /><br/><br/>
    <input type="submit" value="登录" />
</form>
</body>
</html>
