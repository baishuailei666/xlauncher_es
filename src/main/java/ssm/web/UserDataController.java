package ssm.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.entity.UserData;
import ssm.service.UserDataService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserDataController {

    @Autowired

    private UserDataService userDataService;


    /**
     * 查询用户
     * @param id
     * @return 返回查询的用户，为空返回null
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserData getUserDataById(@PathVariable("id") String id) {
        int user_id = Integer.parseInt(id);
        UserData userData = this.userDataService.getUserData(user_id);
        return userData;
    }


    /**
     * 查询所有用户的信息
     * @return 用户信息的列表
     */
    @RequestMapping(value = "/getAllUsersData", method = RequestMethod.GET)
    public String getAll(Model model){

        List<UserData> userDataList = userDataService.getAllUsersData();
        model.addAttribute("user_data_list", userDataList);

        return "user_data";
    }




    @RequestMapping(value = "/getAllUserJson",method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public @ResponseBody
    List<UserData> list(){

        return userDataService.getAllUsersData();
    }


}
