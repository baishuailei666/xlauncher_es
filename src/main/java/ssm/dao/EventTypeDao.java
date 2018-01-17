package ssm.dao;


import org.springframework.stereotype.Service;
import ssm.entity.EventType;

import java.util.List;

@Service
public interface EventTypeDao {

    /**
     * 添加事件类型信息
     * @param eventType
     * @return 插入状态码，成功返回1
     */
    public int addEventType(EventType eventType);

    /**
     * 删除事件描述信息
     * @param type_id
     * @return 删除事件描述信息的操作结果，删除成功返回1
     */
    public int deleteEventType(int type_id);

    /**
     * 更新事件描述信息，增量更新
     * @param eventType
     * @return
     */
    public int updateEventType(EventType eventType);


    /**
     * 查询事件描述信息，根据content_id获取事件描述信息
     * @param type_id
     * @return 查询事件描述信息
     */
    public EventType getEventType(int type_id);

    /**
     * 查询所有事件描述信息
     * @return
     */
    public List<EventType> getAllEventsType();
}
