package PropertyUtil.entity;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Desc: properties文件获取工具实体类
 *
 * Desc：在该类被加载的时候，它就会自动读取指定为位置的配置文件内容并保存到静态属性中，
 *      连工具类对象都不需要注入，直接调用静态方法进行获取，高效且方便，一次加载，多次使用。
 *
 * Created by baiShuaiLei on 2018/1/22.
 */
public class ServicePropertyUtil {

    private static final Logger logger = Logger.getLogger(ServicePropertyUtil.class);
    private static Properties properties;

    static {
        loadProperties();
    }

    synchronized static private void loadProperties(){
        logger.info("开始加载文件内容...");
        properties = new Properties();
        InputStream inputStream = null;

        try{
            // 第一种，通过类加载器进行获取properties文件流
            inputStream = ServicePropertyUtil.class.getClassLoader().getResourceAsStream("aa.properties");

            // 第二种，通过类进行properties文件流
            //inputStream = ServicePropertyUtil.class.getResourceAsStream("/jdbc.properties");

            properties.load(inputStream);

        } catch (FileNotFoundException e){

            logger.error("jdbc.properties文件未找到！");
        } catch (IOException e) {

            logger.error("出现IOException异常！");
        } finally {
            try{
                if (null != inputStream){
                    inputStream.close();
                }
            } catch (IOException e){

                logger.error("jdbc.properties文件流关闭出现异常！");
            }
        }

        logger.info("加载properties文件内容完成...");
        logger.info("properties文件内容："+properties);
    }


    /**
     * 获取properties文件所有内容
     *
     * @return
     */
    public static Properties getPropertyAll(){
        return properties;
    }


    /**
     *  方式一：获取properties文件内容指定key
     *  @param key
     *
     *  @return
     */
    public static String getPropertyOne(String key){
        if (null == properties){

            loadProperties();
        }
        return properties.getProperty(key);
    }


    /**
     *  方式二：获取properties文件内容指定key
     *  @param key
     *
     *  @return
     */
    public static String getPropertyTwo(String key,String defaultValue){
        if (null == properties){

            loadProperties();
        }
        return properties.getProperty(key, defaultValue);
    }

}
