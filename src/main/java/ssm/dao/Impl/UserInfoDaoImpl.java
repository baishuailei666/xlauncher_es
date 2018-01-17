package ssm.dao.Impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import ssm.dao.IUserInfoDao;
import ssm.entity.UserInfo;
import java.util.List;

public class UserInfoDaoImpl extends SqlSessionDaoSupport implements IUserInfoDao {


    public void add(UserInfo userInfo) {
        //return this.getSqlSession().insert("ssm.mapping.UserMapper.add",userInfo);
    }

    public List<UserInfo> getAllUsers() {
        return this.getSqlSession().selectList("ssm.mapping.UserMapper.getAllUsers");
    }

    public void getOneUser(String name) {

    }


}
