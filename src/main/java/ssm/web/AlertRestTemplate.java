package ssm.web;


import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ssm.entity.AlertEvent;
import ssm.service.AlertEventService;

import java.util.List;
import java.util.Map;


/**
 * RestTemplate是Spring提供的用于访问Rest服务的客户端
 * 通过提供便捷的方法访问远程HTTP服务
 */
public class AlertRestTemplate {

    private static Logger logger = Logger.getLogger(AlertRestTemplate.class);
    RestTemplate rest = new RestTemplate();

    /**
     * 从CC端得到事件信息
     */
    public Map<String, Object> getForEntity(String url){
        logger.info("得到事件告警信息");
        ResponseEntity<Map> mapResponseEntity = rest.getForEntity(url,Map.class);
        Map<String, Object> maps =  mapResponseEntity.getBody();

        return maps;

    }



    /**
     * 将事件信息转发推送给CMS端
     */
    public int postForObject(AlertEvent alertEvent, String postUrl) throws Exception {

        logger.info("转发事件告警信息");
//        请求Header设置；jsonData是传送的数据参数；headers头已经设置为json格式，且字符编码是UTF-8的
//        HttpHeaders headers =new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        HttpEntity request=new HttpEntity(jsonData, headers);
//        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
//        headers.add("Accept", "application/json");
//        headers.add("Content-Type", "application/json");
//        String requestBody = "{\"statename\":\""  + "\"}";
//        HttpEntity request = new HttpEntity(requestBody, headers);

        MultiValueMap<String ,String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type","application/json;charset=UTF-8");
        HttpEntity<Object> hpEntity = new HttpEntity<Object>(alertEvent,headers);

        // 转发推送给指定单位
        ResponseEntity<Map> mapResponseEntity = rest.postForEntity(postUrl,hpEntity,Map.class);
//        Map<String, Object> maps =  mapResponseEntity.getBody();
//        返回状态 200即成功并写入数据库表示推送成功
        int ret = mapResponseEntity.getStatusCodeValue();

        return ret;

    }


    /**
     * 批量将事件信息转发推送给CMS端
     */
    public int postForObjectList(List<AlertEvent> alertEventList, String postUrl) throws Exception {

        logger.info("批量转发事件告警信息");
//        请求Header设置；jsonData是传送的数据参数；headers头已经设置为json格式，且字符编码是UTF-8的
//        HttpHeaders headers =new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        HttpEntity request=new HttpEntity(jsonData, headers);
//        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
//        headers.add("Accept", "application/json");
//        headers.add("Content-Type", "application/json");
//        String requestBody = "{\"statename\":\""  + "\"}";
//        HttpEntity request = new HttpEntity(requestBody, headers);

        MultiValueMap<String ,String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type","application/json;charset=UTF-8");
        HttpEntity<Object> hpEntity = new HttpEntity<Object>(alertEventList,headers);

        // 转发推送给指定单位
        ResponseEntity<Map> mapResponseEntity = rest.postForEntity(postUrl,hpEntity,Map.class);
//        Map<String, Object> maps =  mapResponseEntity.getBody();
//        返回状态 200即成功并写入数据库表示推送成功
        int ret = mapResponseEntity.getStatusCodeValue();

        return ret;

    }

//    public static void main(String[] args) throws Exception {
//        AlertRestTemplate alertRestTemplate = new AlertRestTemplate();
//        AlertEventService alertEventService = null;
//        // 从ES数据库中得到事件告警信息的接口
//        String getUrl = "http://localhost:8080/es/es_alert_event/10001";
//        // 转发推送给指定单位的接口
//        String postUrl = "http://8.11.0.11:8080/cms/alert";
////        String postUrl = "http://8.11.0.7:8080/es/es_alert_event/getAll";
//
//        Map<String, Object> map1= alertRestTemplate.postForObject(getUrl,postUrl);
//        // 如果转发成功则返回状态1，并写入数据库
//        if (map1.get("status").equals(1)){
//            // 添加异常
//            try {
////                RestTemplate rest = new RestTemplate();
////                String u = "http://8.11.0.7:8080/es/es_alert_event/status";
////                rest.put(u,1);
////                alertEventService.updateEventStatus();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

//    }
}
