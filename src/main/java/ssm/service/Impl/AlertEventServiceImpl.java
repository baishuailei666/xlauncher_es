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

    /**
     *  。Spring框架使用注入式，使用@Autowired注释，可以对成员变量、方法和构造函数进行标注，
     *   来完成自动装配的工作，通过@Autowired的使用来消除set，get方法
     *   这里必须明确：@Autowired是根据类型进行自动装配的，如果需要按名称进行装配，则需要配合@Qualifier使用
     *  。@Autowired标注可以放在成员变量上，也可以放在成员变量的set方法上。
     *    前者，Spring会直接将UserDao类型的唯一一个bean赋值给userDao这个成员变量；
     *    后者，Spring会调用setUserDao方法来将UserDao类型的唯一一个bean装配到userDao这个属性中。
     *
     */


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
     * 查询事件，根据event_id获取大于等于id的事件信息
     * @param event_id
     * @return 查到的事件的AlertEvent对象
     */

    public List<AlertEvent> getEventBy2Id(int event_id){
        return this.alertEventDao.getEventBy2Id(event_id);
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
