package com.javaboy.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description： Swagger配置依赖
 * @date ：2022/9/14 11:52
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi(){
        String[] paths = { "/swagger/**" };
        String[] packagedToMatch = { "com.javaboy.swagger.controller" };
        return GroupedOpenApi.builder().group("Swagger模块")
                .pathsToMatch(paths)
                .addOperationCustomizer((operation, handlerMethod) -> {
                    return operation.addParametersItem(new HeaderParameter().name("groupCode").example("测试").description("集团code").schema(new StringSchema()._default("BR").name("groupCode").description("集团code")));
                })
                .packagesToScan(packagedToMatch).build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("javaboy用户系统API")
                        .version("1.0")
                        .description( "一个简单的SpringBoot服务脚手架")
                        .termsOfService("http://doc.xiaominfo.com")
                        .license(new License().name("Apache 2.0")
                                .url("http://doc.xiaominfo.com")));
    }


}
