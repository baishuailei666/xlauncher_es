package ssm.dao;

import org.springframework.stereotype.Service;
import ssm.entity.AlertEvent;
import ssm.entity.EventData;

import java.util.Date;
import java.util.List;


@Service
public interface AlertEventDao {

    /**
     * 添加事件
     * @param alertEvent
     * @return 插入状态码，成功返回1
     */
    public int addEvent(AlertEvent alertEvent);

    /**
     * 批量添加事件
     * @param alertEventList
     * @return 插入状态码，成功返回1
     */
    public int addEventList(List<AlertEvent> alertEventList);

    /**
     * 添加事件状态
     * @param alertEvent
     * @return 插入状态码，成功返回1
     */
    public int updateEventStatus(AlertEvent alertEvent);

    /**
     * 查询事件，根据event_id获取事件信息
     * @param eventId
     * @return 查到的事件的AlertEvent对象
     */
    public AlertEvent getEventById(int eventId);

    /**
     * 查询事件，根据cam_id获取事件信息
     * @param camId
     * @return 查到的事件的AlertEvent对象
     */
    public List<AlertEvent> getEventByCamId(int camId);

    /**
     * 查询事件，根据eventStartTime获取事件信息
     * @param eventStartTime
     * @return 查到的事件的AlertEvent对象
     */
    public List<AlertEvent> getEventByStartTime(String eventStartTime);

    /**
     * 查询所有事件信息
     * @return
     */
    public List<AlertEvent> getAllEvents();


    /**
     *  多条件模糊查询事件信息
     */
    public List<EventData> getEventFromParam(String key);

}
