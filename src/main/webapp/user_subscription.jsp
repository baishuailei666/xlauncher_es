<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/12 0012
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>

<%@ page pageEncoding="UTF-8" language="java" import="java.util.*" %>
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
    <title>用户订阅</title>
</head>

<body>

<!-- form action="./" 指定提交到项目的路径-->
<form action="" method="post" name="forml">
    <h2>欢迎来到用户订阅系统</h2><br>

    用户编号：<input type="text" name="user_id"/><br/>
    用户名称：<input type="text" name="user_name"/><br/>
    事件描述：<input type="text" name="content_id"/><br/>
    订阅时间：<input type="text" name="subscription_time"/><br/>


    <input type="button" value="save" onclick="forml.action='saveUserSubscription';forml.submit();"/>
    <input type="button" value="update" onclick="forml.action='updateUserSubscription';forml.submit();" />
    <input type="button" value="delete" onclick="forml.action='deleteUserSubscription';forml.submit();"/>
    <input type="button" value="条件查询" onclick="forml.action='getUserSubFromParam';forml.submit();"/>
    <input type="button" value="jump" name="jump" onclick="window.location.href='getAllUserData';"/>

</form>
</body>
</html>