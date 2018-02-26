package ssm.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.entity.AlertEvent;
import ssm.entity.EventData;
import ssm.service.AlertEventService;
import ssm.utils.CustomException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
     * 添加事件(event_starttime,event_cam_id,type_id,event_source)
     * @param alertEvent
     * @return 插入数据库操作的返回结果，成功返回1
     */
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public int addEvent(@RequestBody AlertEvent alertEvent) throws Exception{
        logger.info("添加事件告警信息");
        int addEventRet = 0;
        // 添加事件信息
        addEventRet = this.alertEventService.addEvent(alertEvent);
        // 判断添加事件信息状态，添加成功则转发给CMS，添加失败则报异常
        if (addEventRet != 1) {
            // 添加失败则报异常
            logger.error("添加事件告警信息失败");
            throw new CustomException("添加事件告警信息失败！");
        }

        // 转发给CMS
        AlertRestTemplate alertRestTemplate = new AlertRestTemplate();
        try {
            // 转发对象的接口
            /**
             *
             * 这里路径写死了，改成从配置文件读取
             *
             */
            String postUrl = "http://8.16.0.41:8080/cms/alert";
            // 转发的状态信息
            int restRet = alertRestTemplate.postForObject(alertEvent,postUrl);
            AlertEvent alertEventStatus = new AlertEvent();
            alertEventStatus.setEventStartTime(alertEvent.getEventStartTime());

            // 判断转发的状态
            if (restRet == 200) {
                // 转发推送成功则回写数据库已推送
                alertEventStatus.setEventPushStatus("已推送");
                this.alertEventService.updateEventStatus(alertEventStatus);
            } else {
                logger.error("推送失败"+restRet);
                // 转发推送失败则回写数据库未推送
                alertEventStatus.setEventPushStatus("未推送");
                this.alertEventService.updateEventStatus(alertEventStatus);

//                    // 并每隔一段时间重新转发推送直到成功
//                    Timer againTime = new Timer();
//                    // TimerTask(){}第一个参数是要操作的方法，第二个参数是要设定的延迟时间，第三个参数是周期的设定
//                    againTime.schedule(new TimerTask() {// 需要每隔30秒重新推送
//
//                        public AlertEventService alertEventService;
//
//                        @Override
//                        public void run() {
//                            try {
//                                int againRestRet =  alertRestTemplate.postForObject(alertEventList,postUrl);
//                                if (againRestRet == 200){
//                                    alertEventStatus.setEventPushStatus("已推送");
//                                    this.alertEventService.updateEventStatus(alertEventStatus);
//                                    System.exit(0);// 调用System.exit方法，使整个程序（线程）终止
//                                }
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                                logger.error(e);
//                            }
//                        }
//                    }, 30000, 30000);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 返回状态添加成功
        return addEventRet;
    }


//    /**
//     * 批量添加事件(event_starttime,event_cam_id,type_id,event_source)
//     * @param alertEventList
//     * @return 插入数据库操作的返回结果，成功返回1
//     */
//    @ResponseBody
//    @RequestMapping(value = "/list", method = RequestMethod.POST)
//    public int addEventList(@RequestBody List<AlertEvent> alertEventList) throws Exception{
//        logger.info("添加事件告警信息");
//        int addEventRet = 0;
//        // 循环迭代List<AlertEvent> 得到每一个AlertEvent
//        for (int indexList=0; indexList<alertEventList.size(); indexList++) {
//            // 添加事件信息
//             addEventRet = this.alertEventService.addEvent(alertEventList.get(indexList));
//            // 判断添加事件信息状态，添加成功则转发给CMS，添加失败则报异常
//            if (addEventRet != 1) {
//                // 添加失败则报异常
//                logger.error("添加事件告警信息失败");
//                throw new CustomException("添加事件告警信息失败！");
//            }
//
//            // 转发给CMS
//            AlertRestTemplate alertRestTemplate = new AlertRestTemplate();
//            try {
//                // 转发对象的接口
////                String postUrl = "http://8.11.0.11:8080/cms/alert";
//                String postUrl = "http://8.11.0.7:8080/es/es_alert_event/getAll";
//                // 转发的状态信息
//                int restRetList = alertRestTemplate.postForObjectList(alertEventList,postUrl);
//                AlertEvent alertEventStatusList = new AlertEvent();
//                alertEventStatusList.setEventStartTime(alertEventList.get(indexList).getEventStartTime());
//
//                // 判断转发的状态
//                if (restRetList == 200) {
//                    // 转发推送成功则回写数据库已推送
//                    alertEventStatusList.setEventPushStatus("已推送");
//                    this.alertEventService.updateEventStatus(alertEventStatusList);
//                } else {
//                    logger.error("推送失败"+restRetList);
//                    // 转发推送失败则回写数据库未推送
//                    alertEventStatusList.setEventPushStatus("未推送");
//                    this.alertEventService.updateEventStatus(alertEventStatusList);
//
////                    // 并每隔一段时间重新转发推送直到成功
////                    Timer againTime = new Timer();
////                    // TimerTask(){}第一个参数是要操作的方法，第二个参数是要设定的延迟时间，第三个参数是周期的设定
////                    againTime.schedule(new TimerTask() {// 需要每隔30秒重新推送
////
////                        public AlertEventService alertEventService;
////
////                        @Override
////                        public void run() {
////                            try {
////                                int againRestRet =  alertRestTemplate.postForObject(alertEventList,postUrl);
////                                if (againRestRet == 200){
////                                    alertEventStatus.setEventPushStatus("已推送");
////                                    this.alertEventService.updateEventStatus(alertEventStatus);
////                                    System.exit(0);// 调用System.exit方法，使整个程序（线程）终止
////                                }
////                            } catch (Exception e) {
////                                e.printStackTrace();
////                                logger.error(e);
////                            }
////                        }
////                    }, 30000, 30000);
//
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        // 返回状态添加成功
//        return addEventRet;
//    }


    /**
     * 添加事件状态(event_id,event_push_status)
     * 返回ID
     * @param alertEvent
     * @return 插入数据库操作的返回结果，成功返回1
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
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

        int eventId = Integer.parseInt(id);
        logger.info("根据ID:"+eventId +"查询事件信息");
        AlertEvent alertEvent = this.alertEventService.getEventById(eventId);
        return alertEvent;
    }

    /**
     * 根据Cam_id查询事件
     * @param id
     * @return 返回查询的事件，为空返回null
     */
    @ResponseBody
    @RequestMapping(value = "/cam/{id}", method = RequestMethod.GET)
    public Map<String, Object> getEventByCamId(@PathVariable("id") String id) {

        int camId = Integer.parseInt(id);
        logger.info("根据cam_id:"+camId +"查询事件信息");
        List<AlertEvent> lstEvents = this.alertEventService.getEventByCamId(camId);
        Map<String, Object> eventMap = new HashMap<>(2);
        eventMap.put("eventList", lstEvents);
        return eventMap;
    }


    /**
     * 根据eventStartTime查询事件
     * @param eventStartTime
     * @return 返回查询的事件，为空返回null
     */
    @ResponseBody
    @RequestMapping(value = "/startTime/{eventStartTime}", method = RequestMethod.GET)
    public Map<String, Object> getEventByStartTime(@PathVariable("eventStartTime") String eventStartTime){

        logger.info("根据startTime:"+eventStartTime+"查询事件信息");
        List<AlertEvent> lstEvents = this.alertEventService.getEventByStartTime(eventStartTime);
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
     * 多条件模糊查询事件的信息
     * @return 事件信息的列表
     */
    @ResponseBody
    @RequestMapping(value ="/param/{key}" ,method = RequestMethod.GET)
    public Map<String, Object> getEventFromParam(@PathVariable("key") String key) {
        logger.info("多条件模糊查询事件的信息");
        List<EventData> lstEvents = this.alertEventService.getEventFromParam(key);
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
