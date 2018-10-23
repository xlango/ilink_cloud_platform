package com.qianli.ilink.cloud_platform.geteway.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@Data
@ConfigurationProperties(prefix = "cloudplatform.security.oauth2")
public class OAuth2Properties {

    private String jwtSigningKey;

}
