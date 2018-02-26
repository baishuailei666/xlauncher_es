package ssm.entity;


/**
 * 事件信息实体类
 */
public class EventData {
    //实体类的属性和表中字段一致
    private int eventId;   //事件信息编号
    private String eventStartTime; //事件发生时间
    private String typeDescription;    //事件信息类型描述
    private int camId;   //事件发生对应的摄像头编号
    private String eventSource;    //事件发生资源描述
    private String eventPushStatus;   //事件推送状态

    public EventData(){

    }

    public EventData(int eventId, String eventStartTime, String typeDescription, int camId, String eventSource, String eventPushStatus) {
        this.eventId = eventId;
        this.eventStartTime = eventStartTime;
        this.typeDescription = typeDescription;
        this.camId = camId;
        this.eventSource = eventSource;
        this.eventPushStatus = eventPushStatus;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public int getCamId() {
        return camId;
    }

    public void setCamId(int camId) {
        camId = camId;
    }

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public String getEventPushStatus() {
        return eventPushStatus;
    }

    public void setEventPushStatus(String eventPushStatus) {
        this.eventPushStatus = eventPushStatus;
    }


    @Override
    public String toString() {

        return "事件编号："+eventId+"  事件发生时间："+eventStartTime+
                "事件类型："+typeDescription+" 事件对应摄像头编号："+camId+
                "事件资源："+eventSource+"  事件推送状态："+eventPushStatus+" ";

    }
}

