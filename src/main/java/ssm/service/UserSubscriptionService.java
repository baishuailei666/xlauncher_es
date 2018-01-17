package ssm.service;


import org.springframework.stereotype.Service;
import ssm.entity.UserSubscription;

import java.util.List;

@Service
public interface UserSubscriptionService {

    /**
     * 添加用户
     * @param userSubscription
     * @return 插入状态码，成功返回1
     */
    public int addUserSub(UserSubscription userSubscription);

    /**
     * 删除用户
     * @param user_id
     * @return 删除用户订阅的操作结果，删除成功返回1
     */
    public int deleteUserSub(int user_id);

    /**
     * 更新用户订阅信息，增量更新
     * @param userSubscription
     * @return
     */
    public int updateUserSub(UserSubscription userSubscription);



    /**
     * 查询用户，根据用户Id获取用户订阅信息
     * @param user_id
     * @return 查到的用户的UserSub对象
     */
    public UserSubscription getUserSubById(int user_id);

    /**
     * 查询所有用户订阅信息
     * @return
     */
    public List<UserSubscription> getAllUsersSub();



    public List<UserSubscription> getUserSubFromParam(UserSubscription UserSubscription);

}
