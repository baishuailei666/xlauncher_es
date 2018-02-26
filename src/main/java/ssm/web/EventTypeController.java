package ssm.web;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.entity.EventType;
import ssm.service.EventTypeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 事件类型操作控制器
 */
@Controller
@RequestMapping(value = "/es/es_event_type")
public class EventTypeController {

    @Autowired
    private EventTypeService eventTypeService;
    private static Logger logger = Logger.getLogger(EventTypeController.class);

    /**
     * 添加事件类型信息
     * @param eventType
     * @return 插入数据库操作的返回结果，成功返回1
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> addEventType(@RequestBody EventType eventType) {
        int ret = this.eventTypeService.addEventType(eventType);
        logger.info("添加事件类型信息");
        Map<String, Object> retMap = new HashMap<>(1);
        retMap.put("status", ret);
        return retMap;
    }

    /**
     * 删除事件类型信息
     * @param id
     * @return 删除事件类型信息的操作结果，删除成功返回1
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteEventContentById(@PathVariable("id") String id) {
        int ret = this.eventTypeService.deleteEventType(Integer.parseInt(id));
        logger.info("删除"+id+"事件类型信息");
        Map<String, Object> retMap = new HashMap<>(1);
        retMap.put("status", ret);
        return retMap;
    }

    /**
     * 修改事件类型信息-根据提供的ID修改事件类型信息
     * @param eventType
     * @return 修改结果，修改成功返回1
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public Map<String, Object> updateEventContent( @RequestBody EventType eventType) {
        int retUpd = this.eventTypeService.updateEventType(eventType);
        logger.info("修改事件类型信息");
        Map<String, Object> map = new HashMap<>(1);
        map.put("status", retUpd);
        return map;
    }

    /**
     * 查询事件类型信息
     * @param id
     * @return 返回查询的事件类型信息，为空返回null
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public EventType getEventContentById(@PathVariable("id") String id) {
        int type_id = Integer.parseInt(id);
        logger.info("查询"+type_id+"事件类型信息");
        EventType eventType = this.eventTypeService.getEventType(type_id);
        return eventType;
    }

    /**
     * 查询所有事件类型信息
     * @return 事件类型信息的列表
     */
    @ResponseBody
    @RequestMapping( method = RequestMethod.GET)
    public Map<String, Object> getAllEventsType() {
        logger.info("查询所有事件类型信息");
        List<EventType> lstEventsType = this.eventTypeService.getAllEventsType();
        Map<String, Object> userMap = new HashMap<>(2);
        userMap.put("eventTypeList", lstEventsType);
        return userMap;
    }

}
