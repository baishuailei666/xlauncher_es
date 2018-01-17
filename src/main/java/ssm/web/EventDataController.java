package ssm.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.entity.EventData;
import ssm.service.EventDataService;
import java.util.List;

@RequestMapping("/")
@Controller
public class EventDataController {

    @Qualifier("eventDataServiceImpl")
    @Autowired
    private EventDataService eventDataService;

    

//    @RequestMapping(value = "/getEventFromParam",method = RequestMethod.GET)
//    public String getEventFromParam(@ModelAttribute("form")AlertEvent AlertEvent, Model model){
//
//        AlertEvent AlertEvent = new AlertEvent();
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
//
//        List<AlertEvent> alertEventList = event_data_service.getEventFromParam(AlertEvent);
//
//        model.addAttribute("event_data_list",alertEventList);
//
//        return "EventData";
//    }



    @RequestMapping(value = "/getAllEvent", method = RequestMethod.GET)
    public String getAllEvent(Model model){

        List<EventData> eventData_list = eventDataService.getAllEvents();
        model.addAttribute("event_data_list", eventData_list);

        return "event_data";
    }


    //定义 produces="text/html;charset=utf-8" 防止页面自动下载json文件
    @RequestMapping(value = "/getAllEventJson",method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public @ResponseBody
    List<EventData> list(){

        return eventDataService.getAllEvents();
    }











}
