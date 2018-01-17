package ssm.dao;

import org.springframework.stereotype.Service;
import ssm.entity.EventData;

import java.util.List;

@Service
public interface EventDataDao {

    public void add(EventData EventData);


    /**
     * 查询所有事件描述信息
     * @return
     */

    public List<EventData> getAllEvents();

    public List<EventData> getEventFromParam();
}
