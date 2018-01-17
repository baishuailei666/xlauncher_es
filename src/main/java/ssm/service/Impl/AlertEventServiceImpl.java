package ssm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ssm.dao.AlertEventDao;
import ssm.entity.AlertEvent;
import ssm.entity.EventData;
import ssm.service.AlertEventService;

import java.util.List;

@Service
public class AlertEventServiceImpl implements AlertEventService {


    @Autowired
    @Qualifier("alertEventDao")
    private AlertEventDao alertEventDao;

    public void setAlertEventDao(AlertEventDao alertEventDao){this.alertEventDao=alertEventDao;}

    /**
     * 添加用户
     * @param alertEvent
     * @return 插入状态码，成功返回1
     */
    public int addEvent(AlertEvent alertEvent){
        return this.alertEventDao.addEvent(alertEvent);
    }

    /**
     * 添加事件状态
     * @param alertEvent
     * @return 插入状态码，成功返回1
     */
    public int updateEventStatus(AlertEvent alertEvent){
        return this.alertEventDao.updateEventStatus(alertEvent);
    }


    /**
     * 查询用户，根据event_id获取事件信息
     * @param event_id
     * @return 查到的事件的AlertEvent对象
     */

    public AlertEvent getEventById(int event_id){
        return this.alertEventDao.getEventById(event_id);
    }


    /**
     * 查询所有事件信息
     * @return
     */
    public List<AlertEvent> getAllEvents(){
        return this.alertEventDao.getAllEvents();
    }




    /**
     * 输入一些参数查询事件信息
     */
    public List<EventData> getEventFromParam(List<String> alertEvent){
        return this.getEventFromParam(alertEvent);
    }


}
