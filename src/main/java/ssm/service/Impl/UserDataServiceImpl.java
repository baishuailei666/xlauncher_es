package ssm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ssm.dao.UserDataDao;
import ssm.entity.UserData;
import ssm.service.UserDataService;

import java.util.List;


@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    @Qualifier("userDataDao")
    private UserDataDao userDataDao;

    /**
     * 查询用户，根据用户Id获取用户订阅信息
     * @param user_id
     * @return 查到的用户的UserData对象
     */
    public UserData getUserData(int user_id){
        return this.userDataDao.getUserData(user_id);
    }

    /**
     * 查询所有用户订阅信息
     * @return
     */
    public List<UserData> getAllUsersData(){
        return this.userDataDao.getAllUsersData();
    }


    public List<UserData> getUserFromParam(List<String> user_data_paramList) {
        return userDataDao.getUserFromParam(user_data_paramList);
    }
}
