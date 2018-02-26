package LoginAuth.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * user服务层实现类
 * @author 白帅雷
 * @date 2018-02-05
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    /**
     * 获得user登录名和密码
     * @param userName
     * @return
     * @throws Exception
     */
    @Override
    public User getUserInfo(String userName) throws Exception{
        return userDao.getUserInfo(userName);
    }
}
