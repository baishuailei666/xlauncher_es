package AlertEventLog;


import AlertEventLog.service.AlertLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybatis.xml"})
public class SpringUtilTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void getApplicationContext() throws Exception {

        String a = applicationContext.getId();
        String s =applicationContext.getApplicationName();
        String d =applicationContext.getDisplayName();
        applicationContext.getParent();

        System.out.println("。。。。。");
        System.out.println(a);  //输出org.springframework.context.support.GenericApplicationContext@2286778

        System.out.println("---------");
        System.out.println(s);

        System.out.println("*********");
        System.out.println(d);  //输出org.springframework.context.support.GenericApplicationContext@2286778

        System.out.println("~~~~~~~~~");
        System.out.println(applicationContext.getParent()); //输出null

        System.out.println("$$$$$$$$$");
        System.out.println(applicationContext); //输出org.springframework.context.support.GenericApplicationContext@2286778: startup date [Wed Feb 07 09:57:01 CST 2018]; root of context hierarchy


    }

    @Test
    public void getBean() throws Exception {
        applicationContext.getBean("alertLogDao");
        System.out.println(applicationContext.getBean("alertLogDao"));  //输出org.apache.ibatis.binding.MapperProxy@1fcb4808


        applicationContext.getBean(AlertLogService.class);
        System.out.println(applicationContext.getBean(AlertLogService.class));  //输出AlertEventLog.service.AlertLogServiceImpl@7446d8d5

        applicationContext.getBean("alertLogService");
        System.out.println(applicationContext.getBean("alertLogService"));  //输出AlertEventLog.service.AlertLogServiceImpl@7446d8d5

    }
}