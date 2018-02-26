package PropertyUtil;

import PropertyUtil.util.OrderedProperties;

import java.io.*;
import java.util.Iterator;

/**
 *  读写文件
 */
public class PropertyTest {
    public static void main(String[] args) {

//        Properties properties = new Properties();
        // 重写Properties方法 使其能顺序加载
        OrderedProperties orderedProperties = new OrderedProperties();
        String fileIn = "service.properties";
        String fileTo = "ab.properties";
        try{
            // 读取指定属性文件 通过类加载器进行获取properties文件流
            InputStream in = PropertyTest.class.getClassLoader().getResourceAsStream(fileIn);

//            InputStream in = new BufferedInputStream (new FileInputStream("a.properties"));
//            这个方式 会报系统找不到文件异常错误

            // 加载属性列表; 这个方法可以从.properties属性文件对应的文件输入流中，加载属性列表到Properties类对象
            orderedProperties.load(in);
            Iterator<String> it = orderedProperties.stringPropertyNames().iterator();
            while (it.hasNext()){
                String key = it.next();
                System.out.println(key + ":" +orderedProperties.getProperty(key));
            }
            System.out.println(orderedProperties);
            // 关闭流
            in.close();


            // 保存属性到指定文件
            // true表示打开追加方式
            FileOutputStream fos = new FileOutputStream(fileTo,true);
//            properties.setProperty("CMS.name","CMS");
//            properties.setProperty("CMS.ip","192.168.0.18");
//            properties.setProperty("CMS.port","9000");

            orderedProperties.setProperty("name","AAM");
            orderedProperties.setProperty("ip","192.168.0.17");
            orderedProperties.setProperty("port","8000");

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
    }
}
