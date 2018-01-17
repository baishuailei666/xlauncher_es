package ssm.dao;

import org.springframework.stereotype.Service;
import ssm.entity.EventContent;

import java.util.List;


@Service
public interface EventContentDao {

    /**
     * 添加事件描述信息
     * @param eventContent
     * @return 插入状态码，成功返回1
     */
    public int addEventContent(EventContent eventContent);

    /**
     * 删除事件描述信息
     * @param content_id
     * @return 删除事件描述信息的操作结果，删除成功返回1
     */
    public int deleteEventContent(int content_id);

    /**
     * 更新事件描述信息，增量更新
     * @param eventContent
     * @return
     */
    public int updateEventContent(EventContent eventContent);


    /**
     * 查询事件描述信息，根据content_id获取事件描述信息
     * @param content_id
     * @return 查询事件描述信息
     */
    public EventContent getEventContent(int content_id);

    /**
     * 查询所有事件描述信息
     * @return
     */
    public List<EventContent> getAllEventsContent();

}
