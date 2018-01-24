<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/12 0012
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>条件查询用户订阅结果</title>
</head>
<body>
    <br>
    <h2>条件查询用户订阅结果</h2>
    <br>
    <input type="button" name="back" onclick="javascript:history.back(-1);"value="返回"/>
    <input type="button" name="egg" onclick="window.location.href='hello';"value="彩蛋"/>
    <br/><br/><br/>
    <table border="1">
        <tr>
            <td>user_id:</td>
            <td>user_name:</td>
            <td>content_id:</td>
            <td>subscription_time:</td>

        </tr>
        <c:forEach  var="usl" items="${userSubscription_list}">
            <tr>
                <td>${usl.user_id}</td>
                <td>${usl.user_name}</td>
                <td>${usl.content_id}</td>
                <td>${usl.subscription_time}</td>

            </tr>
        </c:forEach>

    </table>

</body>
</html>