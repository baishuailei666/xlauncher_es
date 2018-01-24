package ssm.web;


import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ssm.entity.AlertEvent;


import java.util.Map;


/**
 * RestTemplate是Spring提供的用于访问Rest服务的客户端
 * 通过提供便捷的方法访问远程HTTP服务
 */
public class RestTemplateTest {

    private static Logger logger = Logger.getLogger(RestTemplateTest.class);
    RestTemplate rest = new RestTemplate();


    /**
     * 从CC端得到事件信息
     */
    public Map<String, Object> getForEntityTest(String url){
        logger.info("得到事件告警信息");
        ResponseEntity<Map> mapResponseEntity = rest.getForEntity(url,Map.class);
        Map<String, Object> maps =  mapResponseEntity.getBody();

        return maps;

    }


    /**
     * 将事件信息转发推送给CMS端
     */

    public Map<String ,Object> postForObjectTest(String getUrl,String postUrl){

        logger.info("转发事件告警信息");

//        请求Header设置；jsonData是传送的数据参数；headers头已经设置为json格式，且字符编码是UTF-8的
//        HttpHeaders headers =new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        HttpEntity request=new HttpEntity(jsonData, headers);
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        String requestBody = "{\"statename\":\""  + "\"}";
        HttpEntity request = new HttpEntity(requestBody, headers);

        // 从ES数据库中得到事件告警信息
        ResponseEntity<Map> mapEntity = rest.getForEntity(getUrl,Map.class);
        Map<String, Object> mapData =  mapEntity.getBody();

        // 转发推送给指定单位
        ResponseEntity<Map> mapResponseEntity = rest.postForEntity(postUrl,mapData,Map.class,request);
        Map<String, Object> maps =  mapResponseEntity.getBody();

        return maps;

    }

    public static void main(String[] args) {

        RestTemplateTest restTemplateTest = new RestTemplateTest();
        //AlertEventController alertEventController = new AlertEventController();

        // cc端接口
        String url = "http://localhost:8080/es/es_alert_event/5555";
        Map<String, Object> map=restTemplateTest.getForEntityTest(url);
        // 得到事件信息 调用Controller.addEvent方法 写入数据库
        //alertEventController.addEvent((AlertEvent) map);

        System.out.println(map);


        // 从ES数据库中得到事件告警信息的接口
        String getUrl = "http://localhost:8080/es/es_alert_event/gt=/5555";
        // 转发推送给指定单位的接口
        String postUrl = "http://8.11.0.7:8080/es/es_alert_event/getAll";
        Map<String, Object> map1=restTemplateTest.postForObjectTest(getUrl,postUrl);
        System.out.println(map1);
    }
}
