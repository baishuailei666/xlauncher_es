package RestTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class WebRestTemplate {

    RestTemplate rest = new RestTemplate();

    /**
     * 调用getForEntity 实现get请求 看参数设置
     * @return
     */
    public Map<String, Object> getForEntity1(){
        String url="http://localhost:8989/share-web/restget/www/get/2";
        ResponseEntity<Map> map=rest.getForEntity(url, Map.class);
        Map<String, Object> maps=map.getBody();
        System.out.println(maps);
        return maps;
    }

    /**
     * rest.getForEntity方法 看参数设置 可变参数
     * @return
     */
    public Map<String, Object> getForEntity2(){
        String url="http://localhost:8989/share-web/restget/{param}/get/{red}";
        ResponseEntity<Map>  map=rest.getForEntity(url, Map.class, "www",1);
        Map<String, Object> maps=map.getBody();
        return maps;
    }

    /**
     * test 参数返回字符串
     * map为参数
     * @return
     */
    public String  getForEntity3(){
        String url="http://localhost:8989/share-web/restpath/{param}/get/{red}";
        Map<String, Object> m=new HashMap<String, Object>();
        m.put("param", "test");
        m.put("red", 3);
        ResponseEntity<String>  map=rest.getForEntity(url, String.class,m);
        String str=map.getBody();
        return str;
    }

    /**
     * 有时候后我们需要设置头部信息 本人这次就上当了搞了好的半天
     * 能用于基于HttpEntity 设置头
     * exchange()方法可以用于添加请求和响应头
     * @param url
     * @param param
     * @return
     */
    public String getRequest(){
        String url="http://localhost:8989/share-web/restpath/{param}/get/{red}";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("head", "xxx");
        Map<String, Object> m=new HashMap<String, Object>();
        m.put("param", "test");
        m.put("red", 3);
//       requestHeaders.setAccept(acceptableMediaTypes);
//       requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> requestEntity = new HttpEntity(requestHeaders);
        HttpEntity<String> response = rest.exchange(
                url,
                HttpMethod.GET, requestEntity, String.class, m);
        String str=response.getBody();
        return str;
    }

    public static void main(String[] args) {
        WebRestTemplate web=new WebRestTemplate();

        Map<String, Object> map=web.getForEntity1();
        System.out.println(map);

        Map<String, Object> maps=web.getForEntity2();
        System.out.println(maps);

        String str=web.getForEntity3();
        System.out.println(str);

        String str2=web.getRequest();
        System.out.println(str2);
    }

}
