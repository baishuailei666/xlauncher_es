package ssm.entity;

public class UserData {

    private int user_id;    //用户id
    private String user_name;   //用户名
    private String content_description; //用户订阅内容描述
    private String type_description;    //用户订阅类型描述
    private String subscription_time;   //用户订阅时间



    public UserData(){

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getContent_description() {
        return content_description;
    }

    public void setContent_description(String content_description) {
        this.content_description = content_description;
    }

    public String getType_description() {
        return type_description;
    }

    public void setType_description(String type_description) {
        this.type_description = type_description;
    }

    public String getSubscription_time() {
        return subscription_time;
    }

    public void setSubscription_time(String subscription_time) {
        this.subscription_time = subscription_time;
    }


    @Override
    public String toString() {

        return " 用户: "+user_name+" 订阅内容："+content_description+" 订阅类型："+type_description+" 订阅时间："+subscription_time+" " ;
    }
}
