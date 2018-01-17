<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/12 0012
  Time: 15:50
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
    <title>Alert Event</title>
</head>

<body>
<h2>添加事件信息</h2>
<form action="" method="post" name="forml">

    事件发生的编号：<input type="text" name="event_id"/><br/>
    事件发生的时间：<input type="text" name="event_starttime"/><br/>
    事件发生的地点：<input type="text" name="event_location"/><br/>
    事件设备的编号：<input type="text" name="event_cam_id"/><br/>
    事件类型的编号：<input type="text" name="type_id"/><br/>
    事件描述的编号：<input type="text" name="content_id"/><br/>
    事件资源的描述：<input type="text" name="event_source"/><br/>
    事件处理的状态：<input type="text" name="event_status"/><br/>
    事件推送的状态：<input type="text" name="event_push_status"/><br/>
    事件处理的时间：<input type="text" name="event_endtime"/><br/>


    <input type="submit" value="添加" onclick="forml.action='saveEventData';forml.submit();"/>
    <input type="button" value="查询" onclick="forml.action='getEventFromParam';forml.submit();"/>
    <input type="button" value="跳过" onclick="window.location.href='getAllEvent';"/>
</form>
</body>
</html>
