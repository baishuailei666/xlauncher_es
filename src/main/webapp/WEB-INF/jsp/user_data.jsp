
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>getAllUser</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/getAllUserData.action" method="post">
    <div style="padding:20px;">
        <h2>User Data</h2>
        <br>
        <input type="button" name="back" onclick="javascript:history.back(-1);"value="返回"/>
        <input type="button" name="egg" onclick="window.location.href='hello';"value="彩蛋"/>
    </div>

    <table border="1">
        <tr>
            <td>用户编号:</td>
            <td>用户名称:</td>
            <td>订阅内容:</td>
            <td>订阅类型:</td>
            <td>订阅时间:</td>

        </tr>
        <c:forEach  var="udl" items="${userData_list}">
            <tr>
                <td>${udl.user_id}</td>
                <td>${udl.user_name}</td>
                <td>${udl.content_description}</td>
                <td>${udl.type_description}</td>
                <td>${udl.subscription_time}</td>

            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>