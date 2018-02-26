package AlertEventLog.util.AlertLog;

import AlertEventLog.entity.AlertLog;
import AlertEventLog.service.AlertLogService;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


import java.io.ObjectInputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 使用一个ServerSocket循环监听4560端口，得到请求后，就把这个客户请求交给一个LogRunner线程去处理。
 */

public class LogRunner implements Runnable {

    //使用socket的InputStream创建了一个ObjectInputStream用来反序列化Logging Client发送过来的LoggingEvent对象。
    private ObjectInputStream ois;
    private static int count = 0;

    private AlertLogService alertLogService = (AlertLogService) new FileSystemXmlApplicationContext("classpath:/spring-*.xml").getBean("alertLogService");

    ApplicationContext applicationContext;

    /**
     * 构造函数
     */
    public LogRunner(Socket client) {
        try {
            this.ois = new ObjectInputStream(client.getInputStream());
            this.applicationContext = new FileSystemXmlApplicationContext("classpath:/spring-*.xml");
            this.alertLogService = (AlertLogService) this.applicationContext.getBean("alertLogService");
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

//                Object obj= ois.readObject();
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
                LoggingEvent event = (LoggingEvent) this.ois.readObject();


                /**
                 * 时间戳转换
                 */
                // 得到秒数，Date类型的getTime()返回毫秒数
                long longTime = event.getTimeStamp() / 1000;
                // 自定义日期格式
                SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                // 前面的longTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
                Date date = new Date(longTime * 1000);
                // 得到精确到秒的表示：yyyy/MM/dd HH:mm:ss
                String logDateTime = sdf.format(date);
                // getTimeStamp() 日志产生时间 ; getStartTime() 程序启动时间
                // timeSpan 输出应用程序启动到输出log信息消耗的毫秒数
                long timeSpan = event.getTimeStamp() - event.getStartTime();
                /**
                 * 日志信息
                 */
                //告警日志登记priority
                String priority = event.getLevel().toString();
                //输出对应的线程名称thread
                String thread = event.getThreadName();
                //错误抛出的行line_number
                String lineNumber = event.getLocationInformation().getLineNumber();
                //告警抛出的文件名file_name
                String fileName= event.getLocationInformation().getFileName();
                //告警抛出的类名class_name
                String className = event.getLocationInformation().getClassName();
                //告警抛出的方法名称method_name
                String methodName = event.getLocationInformation().getMethodName();
                //告警抛出自带的信息说明message
                String message = event.getMessage().toString();
                System.out.println("priority:" + priority);
                System.out.println("timespan:" + timeSpan);
                System.out.println("thread: " + thread);
                System.out.println("lineNumber:" + lineNumber);
                System.out.println("fileName: " + fileName);
                System.out.println("className: " + className);
                System.out.println("methodName: " + methodName);
                System.out.println("message: " + message);
                System.out.println("----*----*----*----*----*----*----*----*----*----*----*----");
                if (timeSpan>35000){
                // 保存到数据库
                AlertLog alertLog = new AlertLog();
                alertLog.setPriority(priority);
                alertLog.setTime(logDateTime);
                alertLog.setTimeSpan((int) timeSpan);
                alertLog.setThread(thread);
                alertLog.setLineNumber(lineNumber);
                alertLog.setFileName(fileName);
                alertLog.setClassName(className);
                alertLog.setMethodName(methodName);
                alertLog.setMessage(message);
                System.out.println(alertLog);
                this.alertLogService.addAlertLog(alertLog);
                }

                }

//                Map<String, Object> eventMap = new HashMap();
//
//                eventMap.put("priority", event.getLevel());
//                eventMap.put("time", logDateTime);
//                eventMap.put("timeSpan", timeSpan);
//                eventMap.put("thread", event.getThreadName());
//                eventMap.put("lineNumber", event.getLocationInformation().getLineNumber());
//                eventMap.put("fileNumber", event.getLocationInformation().getFileName());
//                eventMap.put("classNumber", event.getLocationInformation().getClassName());
//                eventMap.put("methodNumber", event.getLocationInformation().getMethodName());
//                eventMap.put("message", event.getMessage());
//                //返回此事件中包含的可丢弃事件。可能NULL是没有这样的消息
//                //eventMap.put("日志记录事件的异常信息 ",event.getThrowableInformation());
//
//                System.out.println(eventMap.toString());
//
//                if (timeSpan > 8000) {
//                    RestTemplate restTemplate = new RestTemplate();
//
//                    String url = "http://8.11.0.7:8080/cms/alarm/add";
//
//                    ResponseEntity<Map> mapEntity = (ResponseEntity<Map>) eventMap;
//                    Map<String, Object> mapData =  mapEntity.getBody();
//
//                    MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
//                    headers.add("Content-Type", "application/json ; charset=UTF-8");
//                    HttpEntity<Object> hpEntity = new HttpEntity<Object>(mapData, headers);
//
//                    ResponseEntity<Map> mapResponseEntity = restTemplate.postForEntity(url, hpEntity, Map.class);
//
//                    System.out.println(mapResponseEntity);
//                }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
