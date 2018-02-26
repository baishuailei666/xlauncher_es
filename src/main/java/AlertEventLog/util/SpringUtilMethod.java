package AlertEventLog.util;


import AlertEventLog.entity.AlertLog;
import AlertEventLog.service.AlertLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.SQLException;

/**
 * 方法二：
 * 创建获取Spring的生成类
 * 普通类调用Spring注解方式的Service层bean
 * @author 白帅雷
 * @date 2018-02-26
 */
@Component  //将工具类注册为Spring组件
public class SpringUtilMethod {
    //添加所需service的私有成员，通过@Autowired获取service层的bean对象
    @Autowired
    private AlertLogService alertLogService;

    private static SpringUtilMethod springUtilMethod;


    public SpringUtilMethod() {

    }

    /**
     * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次，
     * 类似于Servlet的init()方法。被@PostConstruct修饰的方法会在构造函数之后，init()方法之前运行。
     *  关键点：静态初始化一个工具类，
     *  通过注解@PostConstruct 在初始化的时候初始化静态对象和它的静态成员变量alertLogService，
     *  原理是拿到service层bean对象，静态存储下来，防止被释放。
     */
    @PostConstruct
    public void init(){     //关键点：通过@PostConstruct和@PreDestroy方法实现初始化和销毁bean之前进行的操作
        springUtilMethod = this;
        springUtilMethod.alertLogService = this.alertLogService;  //初始化时将已静态化的service实例化
    }

    public static void test() throws SQLException {
        springUtilMethod.alertLogService.getAlertLogCount();
    }

    public int getCount(){
        return springUtilMethod.alertLogService.getAlertLogCount();
    }

    public int addLog(AlertLog alertLog) throws SQLException {
        springUtilMethod.alertLogService.addAlertLog(alertLog);
        return 1;
    }

}
