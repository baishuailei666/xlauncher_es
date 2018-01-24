package ssm.entity;

/**
 * 事件类型实体类
 */
public class EventType {

    private int type_id;    //事件类型编号
    private String type_description;    //事件类型描述

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType_description() {
        return type_description;
    }

    public void setType_description(String type_description) {
        this.type_description = type_description;
    }

    @Override
    public String toString() {
        return " 事件类型编号："+type_id+" 类型描述："+type_description+" " ;
    }
}
