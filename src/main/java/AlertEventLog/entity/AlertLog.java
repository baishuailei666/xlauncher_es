package AlertEventLog.entity;


/**
 * 告警日志
 * @author baishuailei
 * @date 2018-01-25
 */
public class AlertLog {

    private int id ;    //告警日志编号
    private String priority ;   //告警日志等级
    private String time ;   //告警日志发生时间
    private int timeSpan ;  //输出应用程序启动到输出日志消耗毫秒数
    private String thread ;     //告警日志发生线程名称
    private String lineNumber ;   //告警日志发生位置的代码行号
    private String fileName ;   //告警日志发生位置的文件名
    private String className ;   //告警日志发生位置的类名
    private String methodName ;   //告警日志发生位置的方法名
    private String message ;    //告警日志信息

    public AlertLog(){

    }

    /**
     * @param priority
     * @param time
     * @param timeSpan
     * @param thread
     * @param lineNumber
     * @param fileName
     * @param className
     * @param methodName
     * @param message
     */
    public AlertLog(String priority,String time,int timeSpan,String thread,String lineNumber,String fileName,String className,String methodName,String message){
        this.priority = priority;
        this.time = time;
        this.timeSpan = timeSpan;
        this.thread = thread;
        this.lineNumber = lineNumber;
        this.fileName = fileName;
        this.className = className;
        this.methodName = methodName;
        this.message = message;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(int timeSpan) {
        this.timeSpan = timeSpan;
    }

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "alertLog:[告警日志编号："+id+" 信息等级："+priority+" " +
                "告警日志发生时间："+time+" 输出应用程序启动到输出日志毫秒数："+timeSpan+" " +
                "告警日志线程名称："+thread+" 告警日志发生位置的代码行号："+lineNumber+" " +
                "告警日志发生位置的文件名："+fileName+" 告警日志发生位置的类名："+className+" " +
                "告警日志发生位置的方法名："+methodName+" 告警日志信息："+message+"]";
    }

}
