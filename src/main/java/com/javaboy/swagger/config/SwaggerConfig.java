package com.javaboy.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：Swagger配置文件
 * @date ：2022/10/14 10:54
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi swagger(){
        String[] paths = { "/swagger/**" };
        String[] packagedToMatch = { "com.javaboy.swagger.controller" };
        return GroupedOpenApi.builder().group("接口文档")
                .pathsToMatch(paths)
                // 请求头包含授权码
                .addOperationCustomizer(operationCustomizer())
                .packagesToScan(packagedToMatch).build();
    }

    @Bean
    public GroupedOpenApi system(){
        String[] paths = { "/system/**" };
        String[] packagedToMatch = { "com.javaboy.system.controller" };
        return GroupedOpenApi.builder().group("系统管理")
                .pathsToMatch(paths)
                // 请求头包含授权码
                // .addOperationCustomizer((operation, handlerMethod) -> {
                //    return operation.addParametersItem(new HeaderParameter().name("Authorization").example("Authorization").description("授权码").schema(new StringSchema()._default("Authorization").name("请求头").description("授权码")));
                // })
                .packagesToScan(packagedToMatch).build();
    }

    @Bean
    public GroupedOpenApi redis(){
        String[] paths = { "/redis/**" };
        String[] packagedToMatch = { "com.javaboy.redis.controller" };
        return GroupedOpenApi.builder().group("Redis管理")
                .pathsToMatch(paths)
                // 请求头包含授权码
                .addOperationCustomizer(operationCustomizer())
                .packagesToScan(packagedToMatch).build();
    }


    @Bean
    public GroupedOpenApi mongodb(){
        String[] paths = { "/mongodb/**" };
        String[] packagedToMatch = { "com.javaboy.mongodb.controller" };
        return GroupedOpenApi.builder().group("mongodb管理")
                .pathsToMatch(paths)
                // 请求头包含授权码
                .addOperationCustomizer(operationCustomizer())
                .packagesToScan(packagedToMatch).build();
    }
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("javaboy用户系统API")
                        .version("1.0")
                        .description( "一个简单的SpringBoot服务脚手架")
                        .termsOfService("https://github.com/ShenJinyong/")
                        .license(new License().name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")));
    }


    @Bean
    public OperationCustomizer operationCustomizer () {
        return new OperationCustomizer() {
            @Override
            public Operation customize(Operation operation, HandlerMethod handlerMethod) {
                operation.addParametersItem(
                        new HeaderParameter()
                                .name("Authorization")
                                .description("授权码")
                                .schema(new StringSchema())
                                .required(false)
                );
                return operation;
            }
        };
    }


}
