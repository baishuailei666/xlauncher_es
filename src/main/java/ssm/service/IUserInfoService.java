package ssm.service;

import org.springframework.stereotype.Service;
import ssm.entity.UserInfo;
import java.util.List;


/**
 * 业务接口：站在"使用者"角度设计接口 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 */
@Service
public interface IUserInfoService {

    public void add(UserInfo userInfo);

    public List<UserInfo> getAllUsers();

    public void getOneUser(String name);

}
