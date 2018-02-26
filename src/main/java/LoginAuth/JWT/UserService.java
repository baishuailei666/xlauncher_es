package LoginAuth.JWT;

import org.springframework.stereotype.Service;
/**
 * user服务层
 * @author 白帅雷
 * @date 2018-02-05
 */
@Service
public interface UserService {

    /**
     * 获得user登录名和密码
     * @param userName
     * @return
     * @throws Exception
     */
    public User getUserInfo(String userName) throws Exception;
}
