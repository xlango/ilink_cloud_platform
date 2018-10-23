import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;

/**
 * Created on 2018/4/28.
 *
 * @author zlf
 * @since 1.0
 */

@Slf4j
public class Oauth2Test {

    @Test
    public void testJwtParse(){
        String access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ5YW5naGFvNyIsInNjb3BlIjpbImFsbCJdLCJmcm9tIjoiaWxpbmsiLCJleHAiOjE1MzQ4NTQ5MzYsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiJmY2NkNmI0My04NjgxLTQxY2YtYWNlNC0wZThjZWZmMDYyZDEiLCJjbGllbnRfaWQiOiJjbG91ZF9wbGF0Zm9ybV9jbGllbnRJZCJ9.-deO-0ZiZSa6tCsoEF2azm04xTHXRiRNkY8gRlhX2wo";
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey("cloud_platform_jwt_signing_key".getBytes("UTF-8")).parseClaimsJws(access_token).getBody();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("get bytes fail...");
        }
        //获取超时时间
        long exp1 = claims.getExpiration().getTime();
        if(exp1 < System.currentTimeMillis()){
            System.out.println("已过期");
        }else{
            System.out.println("有效期内");
        }
        String username = claims.get("user_name",String.class);
        System.out.println(username);
        System.out.println(JSON.toJSONString(claims));
    }


}
