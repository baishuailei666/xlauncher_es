<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/12 0012
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>

<html>
<head>
    <title>用户订阅成功信息</title>
</head>
<body>
<h2>用户订阅信息
    <br>
    <input type="button" name="back" onclick="javascript:history.back(-1);"value="返回"/>
    <input type="button" name="" value="查看" onclick="window.location.href='getAllUserData';"/>
    <p>
        user_id：${UserSubscription.user_id}<br />
        user_name：${UserSubscription.user_name}<br />
        content_id：${UserSubscription.content_id}<br />
        subscription_time：${UserSubscription.subscription_time}<br />

    </p>

</h2>
</body>
</html>
