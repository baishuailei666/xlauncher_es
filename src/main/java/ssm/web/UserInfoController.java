package ssm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ssm.entity.UserInfo;
import ssm.service.IUserInfoService;


import java.util.List;



@RequestMapping("/")    //来映射Requests请求和处理器 注解为控制器指定可以处理那些URL请求
@Controller //定义一个Controller控制器 负责注册一个bean到Spring上下文中
public class UserInfoController {

    //1、收集参数、验证参数
    //2、绑定参数到命令对象
    //3、将命令对象传入业务对象进行业务处理
    //4、选择下一个页面

    @Autowired
    @Qualifier("userInfoServiceImpl")
    private IUserInfoService iUserInfoService;


    @RequestMapping("/save")
    public String save(@ModelAttribute("form") UserInfo userInfo, Model model){
        // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
        // 存入数据库
        UserInfo user = new UserInfo();
        user.setAge(userInfo.getAge()); //userinfo是从页面得到的
        user.setName(userInfo.getName());
        user.setSex(userInfo.getSex());
        user.setAddress(userInfo.getAddress());
        user.setMoney(userInfo.getMoney());
        user.setTime(userInfo.getTime());
        user.setSport(userInfo.getSport());
        iUserInfoService.add(user);
        // 在页面上显示
        model.addAttribute("userinfo",userInfo);

        return "success";
    }


    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public String getAllUsers(Model model){

        List<UserInfo> userList = iUserInfoService.getAllUsers();
        model.addAttribute("userList",userList);

        return "user";
    }

    @RequestMapping(value = "/getOneUser/{key}", method = RequestMethod.GET)
    public UserInfo getOneUser(@PathVariable("key") String key){

        UserInfo userInfo = iUserInfoService.getOneUser(key);
        return userInfo;
    }

    @RequestMapping(value = "/getJson",method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public @ResponseBody List<UserInfo> list(){

        return iUserInfoService.getAllUsers();
    }













//    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String printHello(ModelMap modelMap){
        //创建模型跟视图，用于渲染页面。并且指定要返回的页面为done页面
        // 使用@ModelAttribute 和 @SessionAttribute传递和保存数据
        modelMap.addAttribute("message","Hello User:");
        modelMap.addAttribute("name", "白帅雷");
        modelMap.addAttribute("age", 22);

        return "hello";
    }


//    @RequestMapping(value = "/handleRequest", method = RequestMethod.GET)
//    public String handleRequest(HttpServletRequest request,
//                                      HttpServletResponse response) throws Exception {
//
//        String uname = request.getParameter("name");
//        Integer uage = Integer.valueOf(request.getParameter("age"));
//
//        UserInfo userInfo = new UserInfo();
//        userInfo.setAge(uage);
//        userInfo.setName(uname);
//        iUserInfoService.add(userInfo);
//
//        return "success";
//
//    }


//    @RequestMapping(value = "/list",method = RequestMethod.GET)
//    private String List(Model model){
//        List<UserInfo> list = iUserInfoService.getAllUsers();
//        model.addAttribute("list",list);
//        return "list";
//    }
//
//
//    //ajax json
//    @RequestMapping(value = "/userInfoResult", method = RequestMethod.GET,produces = {"userInfoResult/json:charset=utf-8"})
//    private Result<UserInfo> userInfoResult(){
//        UserInfo execution = null;
//        try {
//            execution= (UserInfo) iUserInfoService.getAllUsers();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return new Result<UserInfo>(true, execution);
//    }


}
