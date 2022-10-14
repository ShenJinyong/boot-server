package com.javaboy.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        return GroupedOpenApi.builder().group("Swagger模块")
                .pathsToMatch(paths)
                // 请求头包含授权码
                // .addOperationCustomizer((operation, handlerMethod) -> {
                //    return operation.addParametersItem(new HeaderParameter().name("Authorization").example("Authorization").description("授权码").schema(new StringSchema()._default("Authorization").name("请求头").description("授权码")));
                // })
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

}
