package dotest;


import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.dao.IUserInfoDao;
import ssm.entity.UserInfo;


public class SpringMyBatisTest extends SqlSessionDaoSupport {

    //Spring和MyBatis整合的测试类
    private IUserInfoDao iUserInfoDao;
    private ClassPathXmlApplicationContext context;

    public static void main(String[] args) {
        SpringMyBatisTest sm = new SpringMyBatisTest();
        sm.doTest();

    }

    public void doTest(){
        context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        iUserInfoDao = (IUserInfoDao) context.getBean("userInfoDao");
        UserInfo userInfo=new UserInfo();
        userInfo.setName("明天");
        userInfo.setAge(4);
        iUserInfoDao.add(userInfo);
        System.out.println("successful");
        System.out.println(iUserInfoDao.getAllUsers());

    }
}
