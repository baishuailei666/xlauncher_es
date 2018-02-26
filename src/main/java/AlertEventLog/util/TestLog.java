package AlertEventLog.util;

import AlertEventLog.entity.AlertLog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * 测试SpringUtil工具类
 */
public class TestLog {

    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring-mybatis.xml");


    public static void main(String[] args) throws SQLException {
        SpringUtilMethod sum = new SpringUtilMethod();

        System.out.println(sum.getCount());

        System.out.println("- - - - - - - -");

        AlertLog alertLog = new AlertLog();
        alertLog.setPriority("WARN");
        alertLog.setTime("2018-02-26");
        alertLog.setTimeSpan(210000);
        alertLog.setThread("todo");
        alertLog.setLineNumber("20");
        alertLog.setFileName("asd");
        alertLog.setClassName("csa.class");
        alertLog.setMethodName("add");
        alertLog.setMessage("test");
        sum.addLog(alertLog);

        System.out.println("- - - - - - - -");

        applicationContext.getId();
    }
}
