package ssm.service;

import org.springframework.stereotype.Service;
import ssm.entity.UserData;

import java.util.List;

@Service
public interface UserDataService {

    /**
     * 查询用户，根据用户Id获取用户订阅信息
     * @param user_id
     * @return 查到的用户的UserData对象
     */
    public UserData getUserData(int user_id);

    /**
     * 查询所有用户订阅信息
     * @return
     */
    public List<UserData> getAllUsersData();

    public List<UserData> getUserFromParam(List<String> user_data_paramList);
}
