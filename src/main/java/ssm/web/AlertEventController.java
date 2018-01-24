package ssm.web;

import org.apache.log4j.Logger;
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

/**
 * RequestMapping是一个用来处理请求地址映射的注解，可用于类或方法上。
 * 用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径的。
 * 六个属性：
 * value：指定请求的实际地址，指定的地址可以是URL Template模式
 * method：指定请求的method类型，GET,POST,PUT,DELETE等
 * consumes：指定处理请求的提交内容类型（Content-type），例如：application/json,text/html
 * produces：指定返回内容类型，仅当request请求头中的（Accept）类型中包含该指定类型才返回
 * params：指定request中必须包含某些参数值，才给该方法处理
 * headers：指定request中必须包含某些指定的header值，才能给该方法处理请求
 *
 */
@Controller
@RequestMapping(value = "/es/es_alert_event")
public class AlertEventController {

    @Autowired
    private AlertEventService alertEventService;
    // 添加一个记录器
    private static Logger logger = Logger.getLogger(AlertEventController.class);

    /**
     * 添加事件( event_id,event_starttime,event_cam_id,type_id,event_source)
     * @param alertEvent
     * @return 插入数据库操作的返回结果，成功返回1
     */
    @ResponseBody
    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public Map<String, Object> addEvent(@RequestBody AlertEvent alertEvent) {
        int ret = this.alertEventService.addEvent(alertEvent);
        logger.info("添加事件告警信息");
        Map<String, Object> retMap = new HashMap<>(1);
        retMap.put("status", ret);
        return retMap;
    }


    /**
     * 添加事件状态(event_status,event_endtime)
     * 返回ID
     * @param alertEvent
     * @return 插入数据库操作的返回结果，成功返回1
     */
    @ResponseBody
    @RequestMapping(value = "/status",method = RequestMethod.PUT)
    public Map<String, Object> updateEventStatus(@RequestBody AlertEvent alertEvent) {
        int ret = this.alertEventService.updateEventStatus(alertEvent);
        logger.info("添加事件状态");
        Map<String, Object> retMap = new HashMap<>(1);
        retMap.put("status", ret);
        return retMap;
    }


    /**
     * 根据编号ID查询事件
     * @param id
     * @return 返回查询的事件，为空返回null
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AlertEvent getEventById(@PathVariable("id") String id) {

        int event_id = Integer.parseInt(id);
        logger.info("根据ID:"+event_id +"查询事件信息");
        AlertEvent alertEvent = this.alertEventService.getEventById(event_id);
        return alertEvent;
    }

    /**
     * 根据编号ID查询事件范围
     * @param id
     * @return 返回查询的事件，为空返回null
     */
    @ResponseBody
    @RequestMapping(value = "/gt=/{id}", method = RequestMethod.GET)
    public Map<String, Object> getEventBy2Id(@PathVariable("id") String id) {

        int event_id = Integer.parseInt(id);
        logger.info("根据ID:"+event_id +"查询大于等于事件范围信息");
        List<AlertEvent> lstEvents = this.alertEventService.getEventBy2Id(event_id);
        Map<String, Object> eventMap = new HashMap<>(2);
        eventMap.put("eventList", lstEvents);
        return eventMap;
    }

    /**
     * 查询所有事件的信息
     * @return 事件信息的列表
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getAllEvents() {
        logger.info("查询所有事件信息");
        List<AlertEvent> lstEvents = this.alertEventService.getAllEvents();
        Map<String, Object> eventMap = new HashMap<>(2);
        eventMap.put("eventList", lstEvents);
        return eventMap;
    }


    /**
     * RestTemplate推送
     * @return 事件信息
     */
    @ResponseBody
    @RequestMapping(value = "/getAll")
    public Map<String, Object> getAll(@RequestBody Map<String,Object> map) {

        return map;
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
