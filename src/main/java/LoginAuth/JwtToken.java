//package LoginAuth;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.auth0.jwt.interfaces.Claim;
//import com.auth0.jwt.interfaces.DecodedJWT;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author bai
// * @since 2018-02-01
// */
//public class JwtToken {
//    /**
//     *  公用密钥-保存在服务器，客户端是不会知道密钥的，以防被攻击
//     */
//    public static String SECRET = "X123";
//
//
//    /**
//     * 生成 Token
//     * @return
//     * @throws Exception
//     */
//    public static String createToken() throws Exception{
//        // 签发时间
//        Date iatDate = new Date();
//
//        // 过期时间
//        Calendar nowTime = Calendar.getInstance();
//        nowTime.add(Calendar.MINUTE,1);
//        Date expireDate = nowTime.getTime();
//
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("alg","HS256");
//        map.put("typ","JWT");
//        String token = JWT.create()
//                .withHeader(map)//header
//                .withClaim("name","bai")//payload
//                .withClaim("age","22")
//                .withClaim("sex","man")
//                .withExpiresAt(expireDate)//设置过期时间-过期时间要大于签发时间
//                .withIssuedAt(iatDate)//设置签发时间
//                .sign(Algorithm.HMAC256(SECRET));//加密
//
//        return token;
//    }
//
//    /**
//     * 解密 Token
//     * @param token
//     * @return
//     * @throws Exception
//     */
//    public static Map<String,Claim> verofyToken(String token) throws Exception{
//        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
//        DecodedJWT jwt = null;
//
//        try {
//            jwt = verifier.verify(token);
//        } catch (Exception e) {
//            throw new RuntimeException("登录凭证已过时，请重新登录");
//        }
//
//        return jwt.getClaims();
//    }
//}
