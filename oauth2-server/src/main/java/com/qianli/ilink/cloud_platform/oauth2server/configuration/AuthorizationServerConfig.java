package com.qianli.ilink.cloud_platform.oauth2server.configuration;

import com.qianli.ilink.cloud_platform.oauth2server.properties.OAuth2ClientProperties;
import com.qianli.ilink.cloud_platform.oauth2server.properties.OAuth2Properties;
import com.qianli.ilink.cloud_platform.oauth2server.security.MyUserDetailsService;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private OAuth2Properties oAuth2Properties;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private TokenEnhancer jwtTokenEnhancer;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     *定义授权和令牌端点以及令牌服务。
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);

        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> enhancerList = new ArrayList<>();
        enhancerList.add(jwtTokenEnhancer);
        enhancerList.add(jwtAccessTokenConverter);
        tokenEnhancerChain.setTokenEnhancers(enhancerList);
        //jwt
        endpoints.tokenEnhancer(tokenEnhancerChain)
                .accessTokenConverter(jwtAccessTokenConverter);
    }

    /**
     * 作用：用于定义客户端详细信息服务的配置程序。可以初始化客户端详细信息。
     * 客户端详细信息可以通过直接访问底层存储（例如，在情况下为数据库表JdbcClientDetailsService）或通过ClientDetailsManager接口（两个实现ClientDetailsService也都实现）在正在运行的应用程序中更新。
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder build = clients.inMemory();
        if (ArrayUtils.isNotEmpty(oAuth2Properties.getClients())) {
            for (OAuth2ClientProperties config : oAuth2Properties.getClients()) {
                build.withClient(config.getClientId())
                        .secret(passwordEncoder.encode(config.getClientSecret()))
                        .accessTokenValiditySeconds(config.getAccessTokenValiditySeconds())
                        .refreshTokenValiditySeconds(config.getRefreshTokenValiditySeconds())
                        .authorizedGrantTypes("password","client_credentials")
                        .scopes("all");
            }
        }
    }


    /**
     * 定义令牌端点上的安全性约束。
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security){
        security.tokenKeyAccess("permitAll()");
        security.checkTokenAccess("isAuthenticated()");
    }
}
