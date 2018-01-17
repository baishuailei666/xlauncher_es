package ssm.model;

public class RegisterBean {
    private String name;
    private int age;

    public RegisterBean(){

    }

    public String getName(){
        try {
            byte b[]=name.getBytes("utf-8");
            name=new String(b,"utf-8");
            return name;
        }catch (Exception e){
            return name;
        }
    }

    public void setName(String userName){
        this.name=userName;
    }
    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }
}
