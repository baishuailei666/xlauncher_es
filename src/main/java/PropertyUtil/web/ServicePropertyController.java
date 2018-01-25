package PropertyUtil.web;


import PropertyUtil.entity.ServicePropertyUtil;
import PropertyUtil.util.OrderedProperties;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

/**
 * Desc: JAVA程序获取properties文件内容的测试控制器
 *
 * Created by baiShuaiLei on 2018/1/22.
 */

@Controller
@RequestMapping("/pro")
public class ServicePropertyController {


    /**
     * 不需要注入工具类对象，直接调用静态方法进行获取，而且只加载一次，效率很高
     */

     private static Logger logger = Logger.getLogger(ServicePropertyController.class);
     private String readPath = "aa.properties";
     private String writePath = "D:\\Launcher\\resources\\ab.properties";


    /**
     * 得到JSON格式数据写入指定路径文件
     *
     * @param map,readPath,writePath
     * 直接接收JSON格式数据自动转化成map，readPath需要打开文件的路径，writePath需要写入文件的路径
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void saveProperty(@RequestBody Map<String, Object> map){

        logger.info("读写properties文件");
        // 重写properties方法 使其能顺序加载
        OrderedProperties orderedProperties = new OrderedProperties();

        try {
            // 读取指定属性文件 通过类加载器进行获取properties文件流
            InputStream in = ServicePropertyController.class.getClassLoader().getResourceAsStream(readPath);
            // 加载属性文件
            orderedProperties.load(in);
            // 关闭流
            in.close();
            // 设置输出流、输出文件路径；true表示追加方式打开
            FileOutputStream  fos = new FileOutputStream(writePath,true);

            // 迭代循环里面的数据
            for(String eachKey : map.keySet()){
                // 循环得到所有的Key
                for (Object listValue: (ArrayList)map.get(eachKey)) {
                    // listValue是一个List集合，将List转换成Map
                    Map mapValue = (Map)listValue;
                    // 写入properties文件
                    orderedProperties.put(mapValue.get("name")+".name",mapValue.get("name"));
                    orderedProperties.put(mapValue.get("name")+".ip",mapValue.get("ip"));
                    orderedProperties.put(mapValue.get("name")+".port",mapValue.get("port"));
                }
            }
            // 这个方法将Properties类对象的属性列表保存到输出流中
            // 如果comments不为空,保存后的属性文件第一行会是#comments,表示注释信息;如果为空则没有注释信息。
            // 注释信息后面是属性文件的当前保存时间信息
            orderedProperties.store(fos,null);

            // 关闭流
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //无返回值
        return ;
    }


    /**
     * 获取properties文件所有内容
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/test/all",method = RequestMethod.GET)
    public Properties getPropertyAll(){

        return ServicePropertyUtil.getPropertyAll();
    }

    /**
     *  方式一：获取properties文件内容指定key
     *  @param key1
     *
     *  @return
     */
    @ResponseBody
    @RequestMapping(value = "/test1/{key1}",method = RequestMethod.GET)
    public String getPropertyTest1(@PathVariable("key1") String key1){

        return ServicePropertyUtil.getPropertyOne(key1);
    }


    /**
     *  方式二：获取properties文件内容指定key
     *  @param key
     *
     *  @return
     */
    @ResponseBody
    @RequestMapping(value = "/test2/{key}",method = RequestMethod.GET)
    public String getPropertyTest2(@PathVariable("key") String key){

        return ServicePropertyUtil.getPropertyTwo(key,"defaultValue");
    }



}
