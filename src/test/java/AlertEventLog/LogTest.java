package AlertEventLog;


import AlertEventLog.service.AlertLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybatis.xml"})
public class LogTest {

    @Autowired
    AlertLogService alertLogService;

    @Test
    public void test1(){
        alertLogService.getAlertLogCount();
        System.out.println(alertLogService.getAlertLogCount());
    }

}
