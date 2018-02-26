package AlertEventLog.service;

import AlertEventLog.entity.AlertLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;


/**
 * 服务层接口
 */
@Service
public interface AlertLogService {


    /**
     * 添加告警日志信息
     * @param alertLog
     * @return
     */
    int addAlertLog(AlertLog alertLog) throws SQLException;


    /**
     * 查询告警日志信息
     * @param startPos
     * @return
     */
    List<AlertLog> getAlertLogByPage(@Param(value="startPos") int startPos) throws SQLException;


    int getAlertLogCount();
}
