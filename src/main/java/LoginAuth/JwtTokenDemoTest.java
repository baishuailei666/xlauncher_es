//package LoginAuth;
//
//import com.auth0.jwt.interfaces.Claim;
//
//import java.util.Map;
//
///**
// * @author bai
// * @since 2018-02-01
// */
//public class JwtTokenDemoTest {
//    public static void main(String[] args) throws Exception{
//
//        String token =  JwtToken.createToken();
//        System.out.println("Token :"+token);
//
//        Map<String,Claim> claimMap = JwtToken.verofyToken(token);
//        System.out.println(claimMap.get("name").asString());
//        System.out.println(claimMap.get("age").asString());
//        System.out.println(claimMap.get("sex") == null ? null:claimMap.get("sex").asString());
//
//        // 使用过期后的 token进行验证
//        String tokenExpire = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
//                "eyJzZXgiOiJtYW4iLCJuYW1lIjoiYmFpIiwiZXhwIjoxNTE3NDcwNjM1LCJhZ2UiOiIyMiJ9." +
//                "cHDXNN2Cbzs_EN_uxmvbm523MF12e9K91td_6xiVy9Y";
//        Map<String,Claim> claimMapExpire = JwtToken.verofyToken(tokenExpire);
//
//    }
//}
