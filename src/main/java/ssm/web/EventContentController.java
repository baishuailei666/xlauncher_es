package ssm.web;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.entity.EventContent;
import ssm.service.EventContentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 事件操作控制器
 */
@Controller
@RequestMapping(value = "/es_event_content")
public class EventContentController {
    @Autowired
    private EventContentService eventContentService;
    private static Logger logger = Logger.getLogger(EventContentController.class);

    /**
     * 添加事件描述信息
     * @param eventContent
     * @return 插入数据库操作的返回结果，成功返回1
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> addEventContent(@RequestBody EventContent eventContent) {
        int ret = this.eventContentService.addEventContent(eventContent);
        logger.info("添加事件描述信息");
        Map<String, Object> retMap = new HashMap<>(1);
        retMap.put("status", ret);
        return retMap;
    }

    /**
     * 删除事件描述信息
     * @param id
     * @return 删除事件描述信息的操作结果，删除成功返回1
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteEventContentById(@PathVariable("id") String id) {
        int ret = this.eventContentService.deleteEventContent(Integer.parseInt(id));
        logger.info("删除"+id+"事件描述信息");
        Map<String, Object> retMap = new HashMap<>(1);
        retMap.put("status", ret);
        return retMap;
    }

    /**
     * 修改事件描述信息-根据提供的ID修改事件描述信息
     * @param eventContent
     * @return 修改结果，修改成功返回1
     */
    @ResponseBody
    @RequestMapping(value = "/post", method = RequestMethod.PUT)
    public Map<String, Object> updateEventContent( @RequestBody EventContent eventContent) {
        int retUpd = this.eventContentService.updateEventContent(eventContent);
        logger.info("修改事件描述信息");
        Map<String, Object> map = new HashMap<>(1);
        map.put("status", retUpd);
        return map;
    }

    /**
     * 查询事件描述信息
     * @param id
     * @return 返回查询的事件描述信息，为空返回null
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public EventContent getEventContentById(@PathVariable("id") String id) {
        int content_id = Integer.parseInt(id);
        logger.info("查询"+id+"事件描述信息");
        EventContent eventContent = this.eventContentService.getEventContent(content_id);
        return eventContent;
    }

    /**
     * 查询所有事件描述信息
     * @return 事件描述信息的列表
     */
    @ResponseBody
    @RequestMapping( method = RequestMethod.GET)
    public Map<String, Object> getAllEventsContent() {
        logger.info("查询所有事件描述信息");
        List<EventContent> lstEventContent = this.eventContentService.getAllEventsContent();
        Map<String, Object> userMap = new HashMap<>(2);
        userMap.put("eventContentList", lstEventContent);
        return userMap;
    }



}
