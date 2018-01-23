package PropertyUtil.serviceImpl;


import PropertyUtil.service.ServicePropertySer;
import PropertyUtil.entity.ServicePropertyUtil;
import org.springframework.stereotype.Service;

import java.util.Properties;


/**
 * Desc: JAVA程序获取properties文件内容的service的实现类
 *
 * Created by baiShuaiLei on 2018/1/22.
 */

@Service
public class ServicePropertySerImpl implements ServicePropertySer {


    @Override
    public Properties getPropertyAll() {
        return ServicePropertyUtil.getPropertyAll();
    }

    @Override
    public String getPropertyTest1(String key) {
        return ServicePropertyUtil.getPropertyOne(key);
    }

    @Override
    public String getPropertyTest2(String key, String defaultValue) {
        return null;
    }
}
