package AlertEventLog.dao;

import AlertEventLog.entity.AlertLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlertLogDao {

    /**
     * 添加告警日志信息
     * @param alertLog
     * @return
     */
    int addAlertLog(AlertLog alertLog);

    /**
     * 分页查询
     * @param startPos
     * @return
     */
    List<AlertLog> getAlertLogByPage(@Param(value="startPos") int startPos);

    /**
     * 总数
     * @return
     */
    int getAlertLogCount();
}
