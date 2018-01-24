package RestTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WebRestTeamplatePost {

    RestTemplate rest=new RestTemplate();

    public Map<String, Object> postForEntity(){

        String url="http://localhost:8080/share-web/restpost";
        //设置head
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("head", "password");
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> m=new HashMap<String, Object>();
        m.put("param", "test");
        m.put("red", 3);
        //通过HttpEntity 设置参数 head
        HttpEntity<?> request=new HttpEntity(m, requestHeaders);
        //url地址 request请求参数 responsType 返回值类型 请求参数
        ResponseEntity<Map> entitymap= rest.postForEntity(url, request, Map.class);
        Map<String, Object> map=entitymap.getBody();
        return map;
    }

    public Map<String, Object> postObject(){

        String url="http://localhost:8080/share-web/restpost";
        //设置head
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("head", "password");
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> m=new HashMap<String, Object>();
        m.put("param", "test");
        m.put("red", 3);
        //通过HttpEntity 设置参数 head
        HttpEntity<?> request=new HttpEntity(m, requestHeaders);
        //url地址 request请求参数 responsType 返回值类型 请求参数
        Map<String, Object> mapobj= rest.postForObject(url, request, Map.class);
        return mapobj;
    }

    public static void main(String[] args) {
        WebRestTeamplatePost web=new WebRestTeamplatePost();

        Map<String, Object> map=web.postObject();
        System.out.println(map);

        Map<String, Object> maps=web.postForEntity();
        System.out.println(maps);
    }

}
