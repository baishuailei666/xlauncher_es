package ssm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ssm.entity.EventData;
import ssm.dao.EventDataDao;
import ssm.service.EventDataService;

import java.util.List;


@Service
public class EventDataServiceImpl implements EventDataService {

    @Qualifier("eventDataDao")
    @Autowired
    private EventDataDao eventDataDao;


    public void add(EventData EventData) {
        eventDataDao.add(EventData);
    }

    /**
     * 查询所有事件描述信息
     * @return
     */
    public List<EventData> getAllEvents() {
        return eventDataDao.getAllEvents();
    }


    public List<EventData> getEventFromParam() {
        return eventDataDao.getEventFromParam();
    }
}
