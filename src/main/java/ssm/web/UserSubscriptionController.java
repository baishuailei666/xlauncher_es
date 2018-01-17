package ssm.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ssm.entity.UserSubscription;
import ssm.service.UserSubscriptionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户订阅操作控制器
 */
@Controller
@RequestMapping("/es_user_subscription")
public class UserSubscriptionController {

    @Autowired
    private UserSubscriptionService userSubscriptionService;


    /**
     * 添加用户
     * @param userSubscription
     * @return 插入数据库操作的返回结果，成功返回1
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> addUserSub(@RequestBody UserSubscription userSubscription) {
        int ret = this.userSubscriptionService.addUserSub(userSubscription);
        Map<String, Object> retMap = new HashMap<>(1);
        retMap.put("status", ret);
        return retMap;
    }

    /**
     * 删除用户
     * @param id
     * @return 删除用户的操作结果，删除成功返回1
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteUserSubById(@PathVariable("id") String id) {
        int ret = this.userSubscriptionService.deleteUserSub(Integer.parseInt(id));
        Map<String, Object> retMap = new HashMap<>(1);
        retMap.put("status", ret);
        return retMap;
    }

    /**
     * 修改用户-根据提供的用户ID修改用户的信息
     * @param userSubscription
     * @return 修改结果，修改成功返回1
     */
    @ResponseBody
    @RequestMapping( method = RequestMethod.PUT)
    public Map<String, Object> updateUserSub( @RequestBody UserSubscription userSubscription) {
        int retUpd = this.userSubscriptionService.updateUserSub(userSubscription);
        Map<String, Object> map = new HashMap<>(1);
        map.put("status", retUpd);
        return map;
    }

    /**
     * 查询用户
     * @param id
     * @return 返回查询的用户，为空返回null
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserSubscription getUserSubById(@PathVariable("id") String id) {
        int user_id = Integer.parseInt(id);
        UserSubscription userSub = this.userSubscriptionService.getUserSubById(user_id);
        return userSub;
    }

    /**
     * 查询所有用户的信息
     * @return 用户信息的列表
     */
    @ResponseBody
    @RequestMapping( method = RequestMethod.GET)
    public Map<String, Object> getAllUsersSub() {
        List<UserSubscription> lstUsersSub = this.userSubscriptionService.getAllUsersSub();
        Map<String, Object> userMap = new HashMap<>(2);
        userMap.put("userSubList", lstUsersSub);
        return userMap;
    }







//    @RequestMapping(value = "/getUserSubFromParam",method = RequestMethod.POST)
//    public String getUserSubFromParam(@ModelAttribute("form")UserSubscription UserSubscription, Model model){
//
//        // UserSubscription:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
//        UserSubscription user_sub = new UserSubscription();
//
//        user_sub.setUser_id(UserSubscription.getUser_id());
//        user_sub.setUser_name(UserSubscription.getUser_name());
//        user_sub.setContent_id(UserSubscription.getContent_id());
//        user_sub.setSubscription_time(UserSubscription.getSubscription_time());
//
//        List<UserSubscription> userSubscription_list = userSubscriptionService.getUserSubFromParam(user_sub);
//        // model用于在页面中显示数据
//        model.addAttribute("user_subscription_list", userSubscription_list);
//
//        return "user_subscription_data";
//    }
//
//
//
//    @RequestMapping("/saveUserSubscription")
//    public String saveUserSubscription(@ModelAttribute("form") UserSubscription UserSubscription, Model model){
//        // UserSubscription:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
//        // 存入数据库
//        UserSubscription user_sub = new UserSubscription();
//        user_sub.setContent_id(UserSubscription.getContent_id()); //从页面得到的
//        user_sub.setUser_name(UserSubscription.getUser_name());
//        user_sub.setSubscription_time(UserSubscription.getSubscription_time());
//
//        UserSubscriptionService.add(user_sub);
//        // 在页面上显示
//        model.addAttribute("user_subscription", UserSubscription);
//
//        return "user_subscription_success";
//    }
//
//
//    @RequestMapping("/updateUserSubscription")
//    public String updateUserSubscription(@ModelAttribute("form")UserSubscription UserSubscription, Model model){
//
//        UserSubscription user_sub = new UserSubscription();
//        user_sub.setUser_id(UserSubscription.getUser_id());
//        user_sub.setContent_id(UserSubscription.getContent_id());
//
//        UserSubscriptionService.update(user_sub);
//
//        model.addAttribute("user_subscription", UserSubscription);
//        return "user_subscription_success";
//    }
//
//    @RequestMapping("/deleteUserSubscription")
//    public String deleteUserSubscription(@ModelAttribute("form")UserSubscription UserSubscription, Model model){
//
//        UserSubscription user_sub = new UserSubscription();
//        user_sub.setUser_id(UserSubscription.getUser_id());
//
//        UserSubscriptionService.delete(user_sub);
//
//        model.addAttribute("user_subscription", UserSubscription);
//        return "user_subscription_success";
//    }


}
