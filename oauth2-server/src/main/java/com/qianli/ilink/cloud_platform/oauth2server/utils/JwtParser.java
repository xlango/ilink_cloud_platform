package com.qianli.ilink.cloud_platform.oauth2server.utils;

import com.qianli.ilink.cloud_platform.oauth2server.properties.OAuth2ClientProperties;
import com.qianli.ilink.cloud_platform.oauth2server.properties.OAuth2Properties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;


@Component
public class JwtParser {

    @Autowired
    private OAuth2Properties oAuth2Properties;

    public Claims parse(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(oAuth2Properties.getJwtSigningKey().getBytes("UTF-8")).parseClaimsJws(token).getBody();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("get bytes fail...");
        }
        String blog = (String) claims.get("blog");
        System.out.println(blog);
        return claims;
    }

}
