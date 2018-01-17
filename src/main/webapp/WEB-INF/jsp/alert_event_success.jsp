<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/12 0012
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>

<html>
<head>
    <title>事件添加成功信息</title>
</head>
<body>
<h2>事件添加成功
    <br>
    <input type="button" name="back" onclick="javascript:history.back(-1);"value="返回"/>
    <input type="button" name="" value="查看" onclick="window.location.href='getAllEvent';"/>
    <p>
        event_id：${alert_event_data.event_id}<br />
        event_starttime：${alert_event_data.event_starttime}<br />
        event_location：${alert_event_data.event_location}<br />
        event_cam_id：${alert_event_data.event_cam_id}<br />
        type_id:${alert_event_data.type_id}<br />
        content_id:${alert_event_data.content_id}<br />
        event_source:${alert_event_data.event_source}<br />
        event_status:${alert_event_data.event_status}<br />
        event_push_status:${alert_event_data.event_push_status}<br />
        event_endtime:${alert_event_data.event_endtime}<br />

    </p>

</h2>
</body>
</html>

