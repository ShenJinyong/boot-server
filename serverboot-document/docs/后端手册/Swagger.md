# Swagger

## 新建项目

> 新建

打开`IDEA`，点击左上角`File`、`New`、`Project`

> 配置

初始化地址栏`Spring Initializr Server URL`：`https://start.aliyun.com`

名称`Name`：`ServerBoot`

位置`Location`：`~\Desktop\mine\ServerBoot`

语言`Language`：`Java`

类型`Type`：`Maven`

组`Group`：`com.javaboy`

坐标`Artifact`：`ServerBoot`

包名称`Package name`：`com.javaboy`

项目JDK版本`Project SDK`：`1.8`

Java：`8`

打包类型`Packaging`：`Jar`

>依赖

点击`next`，`Spring Boot`选择：2.4.1，点击`Web`，勾选`Spring Web`，点击`Finish`。

## 添加Swagger

`pom.xml`

```xml
<!-- OpenAPI3建议使用springdoc-openapi项目 -->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.6.11</version>
</dependency>
```

## 配置文件

`SwaggerConfig`

```java
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
```

## 控制层

```java
@Tag(name = "文档模块")
@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    @Parameter(name = "name",description = "姓名",required = true)
    @Operation(summary = "向客人问好")
    @GetMapping("/sayHi")
    public ResponseEntity<String> sayHi(@RequestParam(value = "name")String name){
        return ResponseEntity.ok("Hi:"+name);
    }
}
```

