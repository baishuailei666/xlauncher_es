package PropertyUtil.service;


import PropertyUtil.entity.ServiceProperty;

import java.util.Properties;

/**
 * Desc: JAVA程序获取properties文件内容的service接口
 *
 * Created by baiShuaiLei on 2018/1/22.
 */
public interface ServicePropertySer {


    /**
     *  实现获取properties文件所有内容
     *  @return
     */
    Properties getPropertyAll();


    /**
     * 实现获取properties文件中指定的key的value
     *
     * @param key
     *
     * @return
     */
    String getPropertyTest1(String key);



    /**
     * 实现获取properties文件中指定的key的value
     *
     * @param key
     *
     * @param defaultValue
     *
     * @return
     */
    String getPropertyTest2(String key, String defaultValue);
}
