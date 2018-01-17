package ssm.entity;

public class AlertEvent {

    //实体类的属性和表中字段一致

    private int event_id;   //事件编号
    private String event_starttime; //事件发生事件
    //private String event_location;  //事件发生地点区域
    private int event_cam_id;   //事件发生对应摄像头编号
    private int type_id;    //事件所属类型编号
    //private int content_id; //事件所属内容编号
    private String event_source;    //事件资源描述
    private String event_status;    //事件目前状态
    //private String event_push_status;   //事件推送状态
    private String event_endtime;   //事件处理时间


    public AlertEvent(int event_id, String event_starttime, String event_location, int event_cam_id, int type_id, int content_id, String event_source, String event_status, String event_push_status, String event_endtime){
        this.event_id = event_id;
        this.event_starttime = event_starttime;
        //this.event_location = event_location;
        this.event_cam_id = event_cam_id;
        this.type_id = type_id;
        //this.content_id = content_id;
        this.event_source = event_source;
        this.event_status = event_status;
        //this.event_push_status = event_push_status;
        this.event_endtime = event_endtime;
    }

    public AlertEvent(int event_id, String event_status, String event_push_status, String event_endtime){
        this.event_id = event_id;
        this.event_status = event_status;
        //this.event_push_status = event_push_status;
        this.event_endtime = event_endtime;
    }

    public AlertEvent(){

    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_starttime() {
        return event_starttime;
    }

    public void setEvent_starttime(String event_starttime) {
        this.event_starttime = event_starttime;
    }





    public int getEvent_cam_id() {
        return event_cam_id;
    }

    public void setEvent_cam_id(int event_cam_id) {
        this.event_cam_id = event_cam_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }



    public String getEvent_source() {
        return event_source;
    }

    public void setEvent_source(String event_source) {
        this.event_source = event_source;
    }

    public String getEvent_status() {
        return event_status;
    }

    public void setEvent_status(String event_status) {
        this.event_status = event_status;
    }


    public String getEvent_endtime() {
        return event_endtime;
    }

    public void setEvent_endtime(String event_endtime) {
        this.event_endtime = event_endtime;
    }

    @Override
    public String toString() {

        return  "事件告警： [事件编号："+event_id+" 事件发生时间："+event_starttime+"" +
                " 事件对应摄像头编号："+event_cam_id+" 事件类型编号："+type_id+" " +
                " 事件资源："+event_source+" 事件状态："+event_status+" 事件处理时间："+event_endtime+"] ";

    }

}
