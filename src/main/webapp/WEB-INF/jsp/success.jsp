<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/6 0006
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>

<html>
<head>
    <title>恭喜恭喜</title>
</head>
<body>
    <h2>注册成功
        <br>
        <input type="button" name="back" onclick="javascript:history.back(-1);"value="返回"/>
        <input type="button" name="" value="查看" onclick="window.location.href='getAllUsers';"/>
        <p>
            id：${userinfo.id}<br />
            name：${userinfo.name}<br />
            age：${userinfo.age}<br />
            sex：${userinfo.sex}<br />
            address：${userinfo.address}<br />
            money：${userinfo.money}<br />
            time:${userinfo.time}<br />
            sport:${userinfo.sport}<br />
        </p>

    </h2>
</body>
</html>
