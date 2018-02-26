package ssm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ssm.dao.AlertEventDao;
import ssm.entity.AlertEvent;
import ssm.entity.EventData;
import ssm.service.AlertEventService;
import ssm.utils.CustomException;

import java.util.Date;
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

    public void setAlertEventDao(AlertEventDao alertEventDao){
        this.alertEventDao=alertEventDao;
    }

    /**
     * 添加事件
     * @param alertEvent
     * @return 插入状态码，成功返回1
     */
    public int addEvent(AlertEvent alertEvent){
        int ret = this.alertEventDao.addEvent(alertEvent);
        if (ret != 1){
            try {
                throw new CustomException("添加事件信息失败!");
            } catch (CustomException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * 批量添加事件
     * @param alertEventList
     * @return 插入状态码，成功返回1
     */
    @Override
    public int addEventList(List<AlertEvent> alertEventList) {
        int ret = this.alertEventDao.addEventList(alertEventList);
        if (ret != 1){
            try {
                throw new CustomException("添加事件信息失败!");
            } catch (CustomException e) {
                e.printStackTrace();
            }
        }
        return ret;
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
     * 查询事件，根据event_id获取事件信息
     * @param eventId
     * @return 查到的事件的AlertEvent对象
     */
    public AlertEvent getEventById(int eventId){
        return this.alertEventDao.getEventById(eventId);
    }

    /**
     * 查询事件，根据cam_id获取事件信息
     * @param camId
     * @return 查到的事件的AlertEvent对象
     */
    public List<AlertEvent> getEventByCamId(int camId){
        return this.alertEventDao.getEventByCamId(camId);
    }

    /**
     * 查询事件，根据eventStartTime获取事件信息
     * @param eventStartTime
     * @return 查到的事件的AlertEvent对象
     */
    public List<AlertEvent> getEventByStartTime(String eventStartTime){
        return this.alertEventDao.getEventByStartTime(eventStartTime);
}

    /**
     * 查询所有事件信息
     * @return
     */
    public List<AlertEvent> getAllEvents(){
        return this.alertEventDao.getAllEvents();
    }




    /**
     * 多条件模糊查询事件信息
     */
    public List<EventData> getEventFromParam(String key){
        return this.alertEventDao.getEventFromParam(key);
    }

}
