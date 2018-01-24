package ssm.entity;

/**
 * 事件内容实体类
 */
public class EventContent {

    private int content_id; // 事件内容编号
    private String content_description; //事件内容描述
    private int type_id;    //事件对应事件类型编号

    public EventContent(int content_id, String content_description, int type_id){

        this.content_id = content_id;
        this.content_description = content_description;
        this.type_id = type_id;
    }

    public EventContent(){

    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public String getContent_description() {
        return content_description;
    }

    public void setContent_description(String content_description) {
        this.content_description = content_description;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    @Override
    public String toString() {
        return " 事件描述编号："+content_id+" 描述内容："+content_description+" " ;
    }

}
