package ssm.entity;

public class UserSubscription {

    private int user_id;    //用户编号
    private String user_name;   //用户名
    private int content_id; //用户订阅内容编号
    private String subscription_time;   //用户订阅时间



    public UserSubscription(int user_id, String user_name, int content_id, String subscription_time) {
        // insert
        this.user_id = user_id;
        this.user_name = user_name;
        this.content_id = content_id;
        this.subscription_time = subscription_time;
    }

    public UserSubscription(){

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

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public String getSubscription_time() {
        return subscription_time;
    }

    public void setSubscription_time(String subscription_time) {
        this.subscription_time = subscription_time;
    }

    @Override
    public String toString() {

        return " 用户: "+user_name+" 订阅内容编号："+content_id+" 订阅时间："+subscription_time+" " ;
    }


}
