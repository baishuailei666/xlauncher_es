<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/10 0010
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>getAllUsers</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/getAllUsers.action" method="post">
        <div style="padding:20px;">
            <h2>用户列表</h2>
            <br>
            <input type="button" name="back" onclick="javascript:history.back(-1);"value="返回"/>
            <input type="button" name="egg" onclick="window.location.href='hello';"value="彩蛋"/>
        </div>

        <table border="1">
            <tr>
                <td>编号:</td>
                <td>姓名:</td>
                <td>年龄:</td>
                <td>性别:</td>
                <td>住址:</td>
                <td>工资:</td>
                <td>时间:</td>
                <td>运动:</td>
            </tr>
            <c:forEach  var="u" items="${userList}">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.name}</td>
                    <td>${u.age}</td>
                    <td>${u.sex}</td>
                    <td>${u.address}</td>
                    <td>${u.money}</td>
                    <td>${u.time}</td>
                    <td>${u.sport}</td>

                </tr>
            </c:forEach>

        </table>
    </form>
</body>
</html>
