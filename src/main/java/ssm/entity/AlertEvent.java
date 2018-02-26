package ssm.entity;

/**
 * 事件实体类
 */
public class AlertEvent {

    //实体类的属性和表中字段一致
    private int eventId;   //事件编号
    private String eventStartTime; //事件发生事件
    private String camId;   //事件发生对应摄像头编号
    private int typeId;    //事件所属类型编号
    private String typeDescription;    //事件类型描述
    private String eventSource;    //事件资源描述
    private String eventPushStatus;   //事件推送状态


    public AlertEvent(){

    }

    public AlertEvent(int eventId,String eventStartTime,String camId,int typeId,String eventSource,String eventPushStatus,String typeDescription){
        this.eventId=eventId;
        this.eventStartTime=eventStartTime;
        this.camId=camId;
        this.typeId=typeId;
        this.eventSource=eventSource;
        this.typeDescription=typeDescription;
        this.eventPushStatus=eventPushStatus;

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

    public String getCamId() {
        return camId;
    }

    public void setCamId(String CamId) {
        this.camId = CamId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
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

        return  "事件告警： [事件编号："+eventId+" 事件发生时间："+eventStartTime+"" +
                " 事件对应摄像头编号："+camId+" 事件类型编号："+typeId+" 事件类型描述："+typeDescription+" " +
                " 事件资源："+eventSource+"  事件推送状态："+eventPushStatus+"] ";

    }

}
