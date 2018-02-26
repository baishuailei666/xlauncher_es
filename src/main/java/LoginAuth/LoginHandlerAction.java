package LoginAuth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * 标记这个类是一个Handler处理器
 */
@Controller
@RequestMapping(value = "/")
public class LoginHandlerAction {


//    @RequestMapping("/hello")
    public String hello(Model model){
        String message = "登录认证成功";
        //为model添加Attribute
        model.addAttribute("message",message);
        return "hello";
    }


    // public ModelAndView handleRequest(HttpServletRequest request,
//   HttpServletResponse response) throws Exception {
//
//  //在页面上提示一行信息
//  String message = "hello world!";
//
//  //通过request对象将信息在页面上展示
//  //request.setAttribute("message", message);
//
//  ModelAndView modelAndView = new ModelAndView();
//  // 相当于request.setAttribute(), 将数据传到页面展示
//  //model数据
//  modelAndView.addObject("message", message);
//  //设置视图
//  modelAndView.setViewName("hello");
//
//  return modelAndView;
// }


}
