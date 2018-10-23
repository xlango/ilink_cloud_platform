package com.qianli.ilink.cloud_platform.geteway.filter;

import com.qianli.ilink.cloud_platform.geteway.properties.OAuth2Properties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;

@Slf4j
@Component
public class AuthenticationFilter implements GlobalFilter, Ordered {

    @Autowired
    private OAuth2Properties oAuth2Properties;

    private final String HEADER_AUTHENTICATED_TOKEN = "Authorization";

    private final String HEADER_AUTHENTICATED_USERID = "x-authenticated-userid";

    private final String UNAUTHENTICATED_REQUEST_URL = "inner";


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        if(exchange.getRequest().getPath().pathWithinApplication().value().contains(UNAUTHENTICATED_REQUEST_URL)){
            return chain.filter(exchange);
        }

        String token = exchange.getRequest().getHeaders().getFirst(HEADER_AUTHENTICATED_TOKEN);
        if (token == null || token.isEmpty()) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String[] jwtToken = token.split(" ");
        if(jwtToken.length != 2){
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        /**
         * 解析jwt token
         */
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(oAuth2Properties.getJwtSigningKey().getBytes("UTF-8")).parseClaimsJws(jwtToken[1]).getBody();
        } catch (UnsupportedEncodingException e) {
            log.error("jwt parser error...",e);
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        /**
         * 判断是否有效
         */
        long exp1 = claims.getExpiration().getTime();
        if(exp1 < System.currentTimeMillis()){
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return exchange.getResponse().setComplete();
        }

        /**
         * 向headers中放入账户属性并修改webExchange对象
         */
        String username = claims.get("user_name",String.class);
        ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate().header(HEADER_AUTHENTICATED_USERID, username).build();
        ServerWebExchange serverWebExchange = exchange.mutate().request(serverHttpRequest).build();

        return chain.filter(serverWebExchange);
    }

    /**
     * 第一个执行
     */
    @Override
    public int getOrder() {
        return -1;
    }
}
