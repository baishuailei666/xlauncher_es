package RestTemplate;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestRestTemplate {
    /**
     * get请求
     * 返回参数自定义 这里返回什么参数客户端接收什么参数
     * @return
     */
    @RequestMapping(value="/restget/{param}/get/{red}",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> restGetRequest(@PathVariable String param,
                                              @PathVariable Integer red){
        Map<String, Object> map =new HashMap<String, Object>();
        map.put("param", param);
        map.put("red", red);
        System.out.println(param);
        return map;
    }

    /**
     * 返回字符串
     * @param param
     * @param red
     * @return
     */
    @RequestMapping(value="/restpath/{param}/get/{red}",method=RequestMethod.GET)
    @ResponseBody
    public String rest(@PathVariable String param,
                       @PathVariable Integer red){
        System.out.println(red);
        return param+":"+red;
    }



    /**
     * post请求
     * @return
     */
    @RequestMapping(value="/restpost",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> restPost(@RequestBody Map<String,Object> map){

        System.out.println(map);
        map.put("aaa", "ffffff");
        return map;
    }
}
