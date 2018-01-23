package PropertyUtil.web;


import PropertyUtil.entity.ServicePropertyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Map;
import java.util.Properties;

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



    /**
     * 得到JSON格式数据写入指定路径文件
     *
     * @param map 直接接收JSON格式数据自动转化成map
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public int saveProperty(@RequestBody Map<String, Object> map){
        // 直接接收JSON数据自动转化成Map

        Properties properties = new Properties();

//        // 定义一个MapList接收多个JSON数据
//        Map<String, Object> mapList = new HashMap<>();
//        mapList.putAll(map);

        try {
            // 读取指定属性文件 通过类加载器进行获取properties文件流
            InputStream in = ServicePropertyController.class.getClassLoader().getResourceAsStream("aa.properties");
            // 加载属性文件
            properties.load(in);
            // 关闭流
            in.close();
            // 设置输出流、输出文件路径；true表示追加方式打开
            FileOutputStream  fos = new FileOutputStream("D:\\Launcher\\resources\\ab.properties",true);
            // put map集合中的数据
            properties.putAll(map);

            // 这个方法将Properties类对象的属性列表保存到输出流中
            // 如果comments不为空,保存后的属性文件第一行会是#comments,表示注释信息;如果为空则没有注释信息。
            // 注释信息后面是属性文件的当前保存时间信息
            properties.store(fos,null);

            // 关闭流
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回1 表示成功
        return 1;
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
