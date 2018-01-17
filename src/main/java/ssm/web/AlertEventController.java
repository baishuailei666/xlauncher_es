package ssm.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.entity.AlertEvent;
import ssm.service.AlertEventService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 事件操作控制器
 */
@Controller
@RequestMapping(value = "/es_alert_event")
public class AlertEventController {

    @Autowired
    private AlertEventService alertEventService;


    /**
     * 添加事件( event_id,event_starttime,event_cam_id,type_id,event_source)
     * @param alertEvent
     * @return 插入数据库操作的返回结果，成功返回1
     */
    @ResponseBody
    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public Map<String, Object> addEvent(@RequestBody AlertEvent alertEvent) {
        int ret = this.alertEventService.addEvent(alertEvent);
        Map<String, Object> retMap = new HashMap<>(1);
        retMap.put("status", ret);
        return retMap;
    }


    /**
     * 添加事件状态(event_status,event_endtime)
     * @param alertEvent
     * @return 插入数据库操作的返回结果，成功返回1
     */
    @ResponseBody
    @RequestMapping(value = "/status",method = RequestMethod.PUT)
    public Map<String, Object> updateEventStatus(@RequestBody AlertEvent alertEvent) {
        int ret = this.alertEventService.updateEventStatus(alertEvent);
        Map<String, Object> retMap = new HashMap<>(1);
        retMap.put("status", ret);
        return retMap;
    }


    /**
     * 查询用户
     * @param id
     * @return 返回查询的用户，为空返回null
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AlertEvent getEventById(@PathVariable("id") String id) {
        int event_id = Integer.parseInt(id);
        AlertEvent alertEvent = this.alertEventService.getEventById(event_id);
        return alertEvent;
    }

    /**
     * 查询所有用户的信息
     * @return 用户信息的列表
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getAllEvents() {
        List<AlertEvent> lstEvents = this.alertEventService.getAllEvents();
        Map<String, Object> eventMap = new HashMap<>(2);
        eventMap.put("eventList", lstEvents);
        return eventMap;
    }





/*
@RequestMapping(value = "/getEventFromParam",method = RequestMethod.POST)
public String getEventFromParam(@ModelAttribute("form")AlertEvent AlertEvent, Model model){

//        AlertEvent AlertEvent = new AlertEvent();
//
//        AlertEvent.setEvent_id(AlertEvent.getEvent_id());
//        AlertEvent.setEvent_starttime(AlertEvent.getEvent_starttime());
//        AlertEvent.setEvent_location(AlertEvent.getEvent_location());
//        AlertEvent.setEvent_cam_id(AlertEvent.getEvent_cam_id());
//        AlertEvent.setType_id(AlertEvent.getType_id());
//        AlertEvent.setContent_id(AlertEvent.getContent_id());
//        AlertEvent.setEvent_source(AlertEvent.getEvent_source());
//        AlertEvent.setEvent_status(AlertEvent.getEvent_status());
//        AlertEvent.setEvent_push_status(AlertEvent.getEvent_push_status());
//        AlertEvent.setEvent_endtime(AlertEvent.getEvent_endtime());


List<String> alert_eventParamList = new ArrayList<String>();

alert_eventParamList.add(String.valueOf(AlertEvent.getEvent_id()));
alert_eventParamList.add(AlertEvent.getEvent_starttime());
alert_eventParamList.add(AlertEvent.getEvent_location());
alert_eventParamList.add(String.valueOf(AlertEvent.getEvent_cam_id()));
alert_eventParamList.add(String.valueOf(AlertEvent.getType_id()));
alert_eventParamList.add(String.valueOf(AlertEvent.getContent_id()));
alert_eventParamList.add(AlertEvent.getEvent_source());
alert_eventParamList.add(AlertEvent.getEvent_status());
alert_eventParamList.add(AlertEvent.getEvent_push_status());
alert_eventParamList.add(AlertEvent.getEvent_endtime());

List<EventData> alertEventList = alertEventService.getEventFromParam(alert_eventParamList);

model.addAttribute("event_data_list",alertEventList);

return "EventData";
}




@RequestMapping(value = "/saveEventData")
public String saveAlertEvent(@ModelAttribute("form")AlertEvent alert_event, Model model){

AlertEvent AlertEvent = new AlertEvent();

AlertEvent.setEvent_id(alert_event.getEvent_id());
AlertEvent.setEvent_starttime(alert_event.getEvent_starttime());
AlertEvent.setEvent_location(alert_event.getEvent_location());
AlertEvent.setEvent_cam_id(alert_event.getEvent_cam_id());
AlertEvent.setType_id(alert_event.getType_id());
AlertEvent.setContent_id(alert_event.getContent_id());
AlertEvent.setEvent_source(alert_event.getEvent_source());

AlertEvent.setEvent_status(alert_event.getEvent_status());
AlertEvent.setEvent_push_status(alert_event.getEvent_push_status());
AlertEvent.setEvent_endtime(alert_event.getEvent_endtime());

alertEventService.addEvent(AlertEvent);
model.addAttribute("alert_event_data",alert_event);

return "alert_event_success";
}
*/


}
