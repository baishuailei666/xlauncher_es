package ssm.model;

/**
 * 封装json对象，所有返回结果都使用它
 */

public class Result<T> {

    private boolean success;    //是否成功标志

    private T data; //成功时返回的数据

    public Result(){

    }

    //成功时的构造器
    public Result(boolean success,T data){
        this.success=success;
        this.data=data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
