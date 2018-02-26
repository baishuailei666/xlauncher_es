package LoginAuth.JWT;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


/**
 * 功能描述：用户登录认证
 * @author ：白帅雷
 * @date：2018-02-05
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    /**
     * 登录验证user信息正确则返回Token，错误则返回status 415
     * 此处用到HttpServletResponse response.setStatus
     * @param user
     * @param response
     * @throws Exception
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> login(@RequestBody Map<String,String> user,HttpServletResponse response) {
        // 传进来的user信息
        String userName = user.get("userName");
        String passWord = user.get("passWord");

        // 数据库中的user信息
        User userList = null;
        try {
            userList = this.userService.getUserInfo(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String userLoginName = userList.getUserName();
        String userPassWord = userList.getPassWord();

        // 定义返回token类型
        Map<String,String> responseMap = new HashMap<>();
        // 判断user信息
        if (userLoginName.equals(userName) && userPassWord.equals(passWord)) {
            // 获得基于JWT的token
            String token = JWT.sign(responseMap,24L * 3600L * 1000L);
            if (token != null) {
                // token
                responseMap.put("token", token);
            }
        } else {
            // error
            responseMap.put("error","error");
            // 返回给页面status
            response.setStatus(415);
        }
        return responseMap;
    }

}