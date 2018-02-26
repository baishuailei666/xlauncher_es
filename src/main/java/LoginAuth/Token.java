package LoginAuth;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;


/**
 * 基于Token登录认证的Token工具类
 * @author baishuailei
 * @date 2018-02-01
 */
public class Token {

    private static final String TOKEN_LIST_NAME = "tokenList";
    public static final String TOKEN_STRING_NAME = "token";

    /**
     * 得到TokenList
     * @param session
     * @return
     */
    private static ArrayList getTokenList(HttpSession session){
        Object obj = session.getAttribute(TOKEN_LIST_NAME);
        if (obj == null){
            return (ArrayList) obj;
        } else {
            ArrayList tokenList = new ArrayList();
            session.setAttribute(TOKEN_LIST_NAME,tokenList);
            return tokenList;
        }
    }

    /**
     * 保存令牌字符串
     * @param tokenStr
     * @param session
     */
    private static void saveTokenString(String tokenStr, HttpSession session){
        ArrayList tokenList = getTokenList(session);
        tokenList.add(tokenStr);
        session.setAttribute(TOKEN_LIST_NAME,tokenList);

    }


    /**
     * 生成令牌字符串
     * @return
     */
    private static  String generateTokenString(){
        return new Long(System.currentTimeMillis()).toString();
    }

    /**
     * 生成一个令牌字符串，并在会话中保存字符串，然后返回令牌字符串
     * @param session
     * @return 返回用于强制执行特定事务的单个请求的令牌字符串
     */
    public static String getTokenString(HttpSession session){
        String tokenStr =  generateTokenString();
        saveTokenString(tokenStr,session);
        return tokenStr;
    }

    /**
     * 检查令牌字符串是否有效。如果会话包含令牌字符串，则返回true，否则返回false
     * @param tokenStr
     * @param session
     * @return true：会话包含tokenStr；false：会话为null，或者tokenStr为id不在会话中。
     */
    public static boolean isTokenStringValid(String tokenStr,HttpSession session){
        boolean valid = false;
        if (session != null){
            ArrayList tokenList = getTokenList(session);
            if (tokenList.contains(tokenStr)){
                valid = true;
                tokenList.remove(tokenStr);
            }
        }
        return valid;
    }

}
