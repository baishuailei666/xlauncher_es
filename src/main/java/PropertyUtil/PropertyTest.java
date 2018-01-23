package PropertyUtil;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

/**
 *  读写文件
 */
public class PropertyTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try{
            // 读取指定属性文件 通过类加载器进行获取properties文件流
            InputStream in = PropertyTest.class.getClassLoader().getResourceAsStream("aa.properties");

//            InputStream in = new BufferedInputStream (new FileInputStream("a.properties"));
//            这个方式 会报系统找不到文件异常错误

            // 加载属性列表; 这个方法可以从.properties属性文件对应的文件输入流中，加载属性列表到Properties类对象
            properties.load(in);
            Iterator<String> it = properties.stringPropertyNames().iterator();
            while (it.hasNext()){
                String key = it.next();
                System.out.println(key + ":" +properties.getProperty(key));
            }
            System.out.println(properties);
            // 关闭流
            in.close();


            // 保存属性到指定文件
            // true表示打开追加方式
            FileOutputStream fos = new FileOutputStream("D:\\Launcher\\resources\\ab.properties");
            properties.setProperty("CMS.name","CMS");
            properties.setProperty("CMS.ip","192.168.0.18");
            properties.setProperty("CMS.port","9002");


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
    }
}
