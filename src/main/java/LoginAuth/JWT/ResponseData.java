package LoginAuth.JWT;

import java.util.HashMap;
import java.util.Map;
/**
 * token返回
 * @author 白帅雷
 * @date 2018-02-05
 */
public class ResponseData {

    // 定义错误信息
    public static final String ERRORS_KEY = "errors";

    // 定义返回的data 包含token
    private final Map<String, Object> Token = new HashMap<>();

    public Map<String, Object> getToken() {
        return Token;
    }

    public ResponseData putTokenValue(String key, Object value) {
        Token.put(key, value);
        return this;
    }

    public ResponseData() {

    }

    public ResponseData(String ERRORS_KEY) {

    }

    public static ResponseData error() {
        return new ResponseData("Customer Error");
    }
}