package AlertEventLog;

import org.apache.log4j.spi.LoggingEvent;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用一个ServerSocket循环监听4560端口，得到请求后，就把这个客户请求交给一个LogRunner线程去处理。
 */


public class LogRunner implements Runnable {

    //使用socket的InputStream创建了一个ObjectInputStream用来反序列化Logging Client发送过来的LoggingEvent对象。
    private ObjectInputStream ois;
    public LogRunner(Socket client) {
        try {
            this.ois = new ObjectInputStream(client.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 说明：把使用日志功能的应用称为Logging Client，把接收和处理日志消息的独立的服务器应用称为Logging Server。
     *
     *
     * 特别注意：我们从Socket中读到的是序列化了的LoggingEvent对象，所以，我们得首先反序列化这个对象，
     *          得到LoggingEvent对象；
     *          在run方法中，使用了一个while（true）无限循环来不断的读入并将读入的二进制内容转成Object对象，
     *          并将Object对象再强转成LoggingEvent。并且，当我们读入一个LoggingEvent对象之后，并没有去关闭ois。
     *
     *
     * 作用：需要考虑SocketAppender的工作方式。当一个Logging Client运行的时候，他对应的SocketAppender就会启动，
     *      并创建一个到指定Logging Server的Socket连接。每当一个日志消息到达SocketAppender之后，
     *      就会直接向这个Socket的 OutputStream写入序列化的对象数据，并通过flush发送到服务器端。
     *      换句话说，就是当一个Logging Client应用创建好之后，就会一直有一个Socket连接到服务器，
     *      这个连接是不会断的，并且一旦有日志消息到达，就直接发送序列化数据。所以我们的服务器端，
     *      就必须在得到一个Socket连接之后，一直维护这个连接，不断的从这个连接中读取数据，
     *      并且不能关闭这个连接。
     *
     */
    @Override
    public void run() {
        try {
            while (true) {

                //Object obj= ois.readObject();
                //System.out.println(obj.toString());

                /**
                 *  序列化（Serialization）：将对象的状态信息转换为可以存储或传输的形式的过程。
                 *      在序列化期间，对象将其当前状态写入到临时或持久性存储区。以后，可以通过从
                 *      存储区中读取或反序列化对象的状态，重新创建对象。
                 *
                 *  三种情况：
                 *      1.将对象存储在硬盘上
                 *      2.将对象通过网络传输
                 *      3.通过RMI远程调用等方式传输对象
                 *      在这三种情况下，是需要进行序列化后再进行传输的。
                 *
                 *  反序列化
                 */
                LoggingEvent event = (LoggingEvent) ois.readObject();

                /**
                 * 时间戳转换
                 */

                // 得到秒数，Date类型的getTime()返回毫秒数
                long longTime = event.getStartTime() / 1000;
                // 自定义日期格式
                SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                // 前面的longTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
                Date date = new Date(longTime * 1000);
                // 得到精确到秒的表示：yyyy/MM/dd HH:mm:ss
                String logDateTime = sdf.format(date);

                Map<String,Object> eventMap = new HashMap();

                eventMap.put("日志记录事件对应级别 ",event.getLevel());
                eventMap.put("日志记录事件产生时间 ",logDateTime);
                eventMap.put("触发日志事件的线程名 ",event.getThreadName());
                eventMap.put("日志发生位置信息代码行号 ",event.getLocationInformation().getLineNumber());
                eventMap.put("日志发生位置信息文件名 ",event.getLocationInformation().getFileName());
                eventMap.put("日志发生位置信息所在类名 ",event.getLocationInformation().getClassName());
                eventMap.put("日志发生位置信息所在函数名 ",event.getLocationInformation().getMethodName());

                //返回此事件中包含的可丢弃事件。可能NULL是没有这样的消息
                eventMap.put("日志记录事件的异常信息 ",event.getThrowableInformation());
                eventMap.put("日志记录事件的内容信息 ",event.getMessage());

                System.out.println(eventMap.toString());

            }
        }catch (Exception e) {
        } finally {
        }
    }
}
