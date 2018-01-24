package LoginAuth;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 *  登录认证控制器
 *
 */
@Controller
public class LoginControl {


    /**
     * 登录系统
     * @param session
     * @param username
     * @param passWord
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login")
    public String login(HttpSession session,String username,String passWord) throws Exception{
        // 在Session里保存信息
        session.setAttribute("username",username);
        // 重定向
        return "redirect:hello.action";
    }


    /**
     * 退出系统
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session)throws Exception{
        // 清除session信息
        session.invalidate();
        return "redirect:hello.action";
    }


}
