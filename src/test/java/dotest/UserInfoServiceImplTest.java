package dotest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ssm.entity.UserInfo;
import ssm.service.IUserInfoService;

import java.util.List;

public class UserInfoServiceImplTest extends UserInfoTest {

    //UserInfoServiceImpl的测试类

    @Qualifier("userInfoServiceImpl")
    @Autowired
    private IUserInfoService iUserInfoService;

    @Test
    public void add() throws Exception{
        UserInfo userInfo = new UserInfo();
        userInfo.setName("昨天");
        userInfo.setAge(11);
        iUserInfoService.add(userInfo);
        System.out.println("Insert the success");
    }

    @Test
    public void getAllUsers() throws Exception{
        List<UserInfo> userInfos = iUserInfoService.getAllUsers();
        for (UserInfo userInfo:userInfos){
            System.out.println(userInfo);
        }
    }


}
