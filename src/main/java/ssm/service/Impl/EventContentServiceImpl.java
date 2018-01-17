package ssm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ssm.dao.EventContentDao;
import ssm.entity.EventContent;
import ssm.service.EventContentService;

import java.util.List;

@Service
public class EventContentServiceImpl implements EventContentService {

    @Qualifier("eventContentDao")
    @Autowired
    private EventContentDao EventContentDao;

    /**
     * 添加事件描述信息
     * @param eventContent
     * @return 插入状态码，成功返回1
     */
    public int addEventContent(EventContent eventContent){
        return this.EventContentDao.addEventContent(eventContent);
    }

    /**
     * 删除事件描述信息
     * @param content_id
     * @return 删除事件描述信息的操作结果，删除成功返回1
     */
    public int deleteEventContent(int content_id){
        return this.EventContentDao.deleteEventContent(content_id);
    }

    /**
     * 更新事件描述信息，增量更新
     * @param eventContent
     * @return
     */
    public int updateEventContent(EventContent eventContent){
        return this.EventContentDao.updateEventContent(eventContent);
    }


    /**
     * 查询事件描述信息，根据content_id获取事件描述信息
     * @param content_id
     * @return 查询事件描述信息
     */
    public EventContent getEventContent(int content_id){
        return this.EventContentDao.getEventContent(content_id);
    }

    /**
     * 查询所有事件描述信息
     * @return
     */
    public List<EventContent> getAllEventsContent(){
        return this.EventContentDao.getAllEventsContent();
    }
}
