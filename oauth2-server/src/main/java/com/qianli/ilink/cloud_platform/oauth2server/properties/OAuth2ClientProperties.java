package com.qianli.ilink.cloud_platform.oauth2server.properties;

import lombok.Data;

@Data
public class OAuth2ClientProperties {

    private String clientId;

    private String clientSecret;

    /**
     * 2小时
     */
    private Integer accessTokenValiditySeconds = 60 * 60 * 2;

    /**
     * 12小时
     */
    private Integer refreshTokenValiditySeconds = 60 * 60 * 12;

}
