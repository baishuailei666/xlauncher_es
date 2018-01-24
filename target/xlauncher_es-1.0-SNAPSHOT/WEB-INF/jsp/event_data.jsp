<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/11 0011
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>getAllEvent</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/getAllEvent.action" method="post">
    <div style="padding:20px;">
        <h2>Event Data</h2>
        <br>
        <input type="button" name="back" onclick="javascript:history.back(-1);"value="返回"/>
        <input type="button" name="egg" onclick="window.location.href='hello';"value="彩蛋"/>
    </div>

    <table border="1">
        <tr>
            <td>事件编号:</td>
            <td>事件发生时间:</td>
            <td>事件类型:</td>
            <td>事件描述:</td>
            <td>事件发生地点:</td>
            <td>事件对应摄像头编号:</td>
            <td>事件资源:</td>
            <td>事件状态:</td>
            <td>事件推送状态:</td>
            <td>事件处理时间:</td>


        </tr>
        <c:forEach  var="edl" items="${eventData_list}">
            <tr>
                <td>${edl.event_id}</td>
                <td>${edl.event_starttime}</td>
                <td>${edl.type_description}</td>
                <td>${edl.content_description}</td>
                <td>${edl.event_location}</td>
                <td>${edl.event_cam_id}</td>
                <td>${edl.event_source}</td>
                <td>${edl.event_status}</td>
                <td>${edl.event_push_status}</td>
                <td>${edl.event_endtime}</td>

            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>