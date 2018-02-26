package LoginAuth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginToken {

    @RequestMapping("/hello")
    public String hello(Model model, HttpServletRequest request){
        if(Token.isTokenStringValid(request.getParameter(Token.TOKEN_STRING_NAME),request.getSession())){
            String message = "登录认证成功";
            //为model添加Attribute
            model.addAttribute("message",message);
            return "hello";
        }
        return "hello";
    }

}
