package LoginAuth.JWT;

/**
 * user实体类
 * @author 白帅雷
 * @date 2018-02-05
 */
public class User {

    private int id;     // user编号
    private String userName;    //userName
    private String passWord;    //passWord

    public User(){

    }

    public User (String userName ,String passWord){
        this.userName=userName;
        this.passWord=passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}