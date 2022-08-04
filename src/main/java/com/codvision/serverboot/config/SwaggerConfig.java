package com.codvision.serverboot.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;

// 该注解是 Springfox-swagger 框架提供的使用 Swagger 注解，该注解必须加
@EnableOpenApi
// 该注解是 knife4j 提供的增强注解，UI 提供了例如动态参数、参数过滤、接口排序等增强功能，如果你想使用这些增强功能就必须加该注解，否则可以不用加
@EnableKnife4j
// 该注解说明是配置类
@Configuration
public class SwaggerConfig {

    /**
     * 定义分隔符
     */
    private static final String splitor = ";";

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(basePackage("com.codvision.serverboot.controller;com.codvision.serverboot.xxx.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName("沈金勇")
                .enable(true);
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("ServerBoot")
                .description("一个快速开始的SpringBoot的脚手架")
                .contact(new Contact("沈金勇","","438217638@qq.com"))
                .version("v1.0")
                .build();
    }

    /**
     * 声明基础包
     *
     * @param basePackage 基础包路径
     * @return
     */
    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    /**
     * 校验基础包
     *
     * @param basePackage 基础包路径
     * @return
     */
    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
        return input -> {
            for (String strPackage : basePackage.split(splitor)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    /**
     * 检验基础包实例
     *
     * @param requestHandler 请求处理类
     * @return
     */
    @SuppressWarnings("deprecation")
    private static Optional<? extends Class<?>> declaringClass(RequestHandler requestHandler) {
        return Optional.fromNullable(requestHandler.declaringClass());
    }

}
