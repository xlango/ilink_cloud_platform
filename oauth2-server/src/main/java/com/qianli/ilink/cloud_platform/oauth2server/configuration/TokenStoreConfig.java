package com.qianli.ilink.cloud_platform.oauth2server.configuration;


import com.qianli.ilink.cloud_platform.oauth2server.properties.OAuth2Properties;
import com.qianli.ilink.cloud_platform.oauth2server.security.jwt.CustomJwtTokenEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


@Configuration
public class TokenStoreConfig {

    /**
     * jwt TOKEN配置信息
     */
    @Configuration
    public static class JwtTokenConfig{

        @Autowired
        private OAuth2Properties oAuth2Properties;

        /**
         * 使用jwtTokenStore存储token
         * @return
         */
        @Bean
        public TokenStore jwtTokenStore(){
            return new JwtTokenStore(jwtAccessTokenConverter());
        }

        /**
         * 用于生成jwt
         * @return
         */
        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter(){
            JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
            //生成签名的key
            accessTokenConverter.setSigningKey(oAuth2Properties.getJwtSigningKey());
            return accessTokenConverter;
        }

        /**
         * 用于扩展JWT
         * @return
         */
        @Bean
        public TokenEnhancer jwtTokenEnhancer(){
            return new CustomJwtTokenEnhancer();
        }

    }

}
