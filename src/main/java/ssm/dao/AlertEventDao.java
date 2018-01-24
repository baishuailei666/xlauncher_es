package ssm.dao;

import org.springframework.stereotype.Service;
import ssm.entity.AlertEvent;
import ssm.entity.EventData;

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
     * 添加事件状态
     * @param alertEvent
     * @return 插入状态码，成功返回1
     */
    public int updateEventStatus(AlertEvent alertEvent);

    /**
     * 查询事件，根据event_id获取事件信息
     * @param event_id
     * @return 查到的事件的AlertEvent对象
     */

    public AlertEvent getEventById(int event_id);

    /**
     * 查询事件，根据event_id获取大于等于id的事件信息
     * @param event_id
     * @return 查到的事件的AlertEvent对象
     */

    public List<AlertEvent> getEventBy2Id(int event_id);

    /**
     * 查询所有事件信息
     * @return
     */
    public List<AlertEvent> getAllEvents();


    /**
     * 输入一些参数查询事件信息
     */
    public List<EventData> getEventFromParam(List<String> alertEvent);


}
