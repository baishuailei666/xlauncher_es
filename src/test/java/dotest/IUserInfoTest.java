package dotest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ssm.dao.IUserInfoDao;
import ssm.entity.UserInfo;

import java.util.List;

public class IUserInfoTest extends UserInfoTest {

    // IUserInfo的测试类
    @Qualifier("IUserInfoDao")
    @Autowired
    private IUserInfoDao iUserInfoDao;

    @Test
    public void getAllUsers() throws Exception{
        List<UserInfo> userInfos = iUserInfoDao.getAllUsers();
        for (UserInfo userInfo:userInfos){
            System.out.println(userInfo);
        }
    }

    @Test
    public void add() throws Exception{
        String name = "今天";
        int age = 12;
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setAge(age);
        iUserInfoDao.add(userInfo);
        System.out.println("Insert the success");
    }

}
