package SocketAppenderTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath*:spring-mybatis.xml"})
public class SocketAppenderTest {

    private Logger logger = Logger.getLogger(String.valueOf(SocketAppenderTest.class));

    @Test
    public void socketAppenderTest() {
        logger.info("log4j测试是否 可以接收并存入数据库");
    }
}
