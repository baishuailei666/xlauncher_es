package ssm.model;

import org.springframework.ui.ModelMap;

public class ModelMapHelper extends ModelMap{
    public void setCode(int code){
        this.put("code",code);
    }
    public void setMsg(String msg){
        this.put("msg",msg);
    }
    public void setData(Object data){
        this.put("data",data);
    }
    public void setCodeAndMsg(int code,String msg){
        this.put("code",code);
        this.put("msg",msg);
    }

    public static void main(String[] args) {
        ModelMapHelper modelMapHelper = new ModelMapHelper();
        modelMapHelper.setCode(1);
        modelMapHelper.setMsg("hello");
        modelMapHelper.setData("你好");
        //modelMapHelper.setCodeAndMsg(2,"明天见");
        System.out.println("modelMapHelper : " + modelMapHelper);
    }


}
