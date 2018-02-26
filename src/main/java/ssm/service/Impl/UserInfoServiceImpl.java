package ssm.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ssm.dao.IUserInfoDao;
import ssm.entity.UserInfo;
import ssm.service.IUserInfoService;

import java.util.List;


@Service
public class UserInfoServiceImpl implements IUserInfoService {

    /**
     * 使用@Autowired注解标注userMapper变量，
     * 当需要使用IUserInfoDao时，Spring就会自动注入IUserInfoDao
     */


    // 注入Service依赖
    @Qualifier("IUserInfoDao")
    @Autowired
    private IUserInfoDao iUserInfoDao;

    /**
     * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     */


    public void add(UserInfo userInfo) {

        try {
            iUserInfoDao.add(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<UserInfo> getAllUsers(){

        try {
            return iUserInfoDao.getAllUsers();
        } catch (Exception e) {
            System.out.println("查询用户信息失败");
        }
        return null;
    }

    public UserInfo getOneUser(String key) {

        try {
            return iUserInfoDao.getOneUser(key);
        } catch (Exception e) {
            System.out.println("根据关键字查询用户信息失败");
        }
        return null;
    }


}
