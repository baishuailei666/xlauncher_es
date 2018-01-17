package ssm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ssm.dao.EventTypeDao;
import ssm.entity.EventType;
import ssm.service.EventTypeService;

import java.util.List;


@Service
public class EventTypeServiceImpl implements EventTypeService {

    @Qualifier("eventTypeDao")
    @Autowired
    private EventTypeDao EventTypeDao;

    public void setEventTypeDao(EventTypeDao EventTypeDao){
        this.EventTypeDao=EventTypeDao;
    }
    /**
     * 添加事件类型信息
     * @param eventType
     * @return 插入状态码，成功返回1
     */
    public int addEventType(EventType eventType){
        return this.EventTypeDao.addEventType(eventType);
    }

    /**
     * 删除事件描述信息
     * @param type_id
     * @return 删除事件描述信息的操作结果，删除成功返回1
     */
    public int deleteEventType(int type_id){
        return this.EventTypeDao.deleteEventType(type_id);
    }

    /**
     * 更新事件描述信息，增量更新
     * @param eventType
     * @return
     */
    public int updateEventType(EventType eventType){
        return this.EventTypeDao.updateEventType(eventType);
    }


    /**
     * 查询事件描述信息，根据content_id获取事件描述信息
     * @param type_id
     * @return 查询事件描述信息
     */
    public EventType getEventType(int type_id){
        return this.EventTypeDao.getEventType(type_id);
    }

    /**
     * 查询所有事件描述信息
     * @return
     */
    public List<EventType> getAllEventsType(){
        return this.EventTypeDao.getAllEventsType();
    }
}
