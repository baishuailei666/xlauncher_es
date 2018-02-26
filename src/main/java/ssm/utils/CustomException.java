package ssm.utils;

/**
 * Created by baishuailei on 2018-01-30
 * 系统自定义异常类
 */
public class CustomException extends Exception {
    // 异常信息
    public String message;
    public CustomException(String message){
        super(message);
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message){
        this.message=message;
    }
}
