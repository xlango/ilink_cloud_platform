package com.qianli.ilink.cloud_platform.commons.core.utils;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerUtils {

    public static Docket createSwagger2(String scanPackage){
        return createRestApi(scanPackage);
    }

    private static Docket createRestApi(String scanPackage) {
        return new Docket(DocumentationType.SWAGGER_2)
                //.globalOperationParameters(pars)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(scanPackage))
                .paths(PathSelectors.any())
                .build();
    }

    private static ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("千立科技APIs")
                .description("千立科技各APIs集成测试")
                // .termsOfServiceUrl("http://blog.didispace.com/")
                .contact("Zhou")
                .version("1.0")
                .build();
    }

}
