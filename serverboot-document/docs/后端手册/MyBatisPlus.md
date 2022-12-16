# MyBatisPlus

## 相关依赖

```xml
<!-- MybatisPlus -->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.2</version>
</dependency>
<!-- 代码自动生成器 -->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.5.1</version>
</dependency>
<!-- 模板引擎 -->
<dependency>
    <groupId>org.apache.velocity</groupId>
    <artifactId>velocity-engine-core</artifactId>
    <version>2.0</version>
</dependency>
<!--junit测试-->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
</dependency>
<!-- MySQL驱动包 -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
<!-- lombok插件 -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>
```

## 添加配置类

`MybatisPlusConfig`

```java
// 事务管理，默认开启
@EnableTransactionManagement
// 该注解说明是配置类
@Configuration
public class MybatisPlusConfig {

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,
     * 需要设置 MybatisConfiguration#useDeprecatedExecutor = false
     * 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 注册乐观锁插件
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        // 注册分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

}
```

## 自动填充

`MyMetaObjectHandler`

```java
// 该注解说明可以使用slf4j日志打印
@Slf4j
// 该注解说明把处理器加载到IOC容器中
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    // 插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ...");
        // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "gmtCreate", Date.class, new Date());
        this.strictUpdateFill(metaObject, "gmtModified", Date.class, new Date());
    }

    // 填充时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ...");
        this.strictUpdateFill(metaObject, "gmtModified", Date.class, new Date());
    }

}
```

## 代码自动生成

`GeneratorTest`

```java
@SpringBootTest
public class GeneratorTest {

    // 定义数据源数据
    private static String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/server_boot";
    private static String DATABASE_USERNAME = "root";
    private static String DATABASE_PASSWORD = "123456";

    @Test
    public void generatorCode(){

        FastAutoGenerator
                // 1.配置数据源
                .create(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD)
                // 2.全局配置
                .globalConfig((scanner, builder) -> builder
                        // 设置作者名
                        .author(scanner.apply("请输入作者名称？"))
                        // 生成代码存放的目录
                        .outputDir(System.getProperty("user.dir") + "/src/main/java")
                        // 注释日期
                        .commentDate("yyyy-MM-dd hh:mm:ss")
                        // 定义生成的实体类中日期的类型 【TIME_PACK=LocalDateTime】、【ONLY_DATE=Date】
                        .dateType(DateType.ONLY_DATE)
                        // 开启Swagger模式
                        .enableSwagger()
                        // 使用FileOverride覆盖开启覆盖模式，默认不覆盖
                         .fileOverride()
                        // 禁止打开输出目录，默认打开
                        .disableOpenDir()
                )
                // 3.包配置
                .packageConfig((scanner, builder) -> builder
                        // 设置父包名
                        .parent("com.javaboy")
                        // 设置模块名
                        .moduleName(scanner.apply("请输入模块名？"))
                        // pojo 实体类
                        .entity("entity")
                        // Service 包名
                        .service("service")
                        // ***ServiceImpl 包名
                        .serviceImpl("service.impl")
                        // Mapper 包名
                        .mapper("mapper")
                        // Mapper XML 包名
                        .xml("mapper")
                        // Controller 包名
                        .controller("controller")
                        // 自定义文件包名
                        .other("utils")
                        // 把mapper里面的xml放到resources目录下
                        .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir")+"/src/main/resources/mapper"))
                )
                // 4.策略配置
                .strategyConfig((scanner, builder) -> builder
                        // 设置需要生成的数据表名
                        .addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有则输入 all")))
                        // 设置过滤前缀，多个使用逗号分隔，过滤不需要生成的数据库表
                        .addTablePrefix("tbl_")

                        // Mapper 策略配置
                        .mapperBuilder()
                        // 设置父类
                        .superClass(BaseMapper.class)
                        // 格式化 mapper 文件名称
                        .formatMapperFileName("%sMapper")
                        // 开启 @Mapper 注解
                        .enableMapperAnnotation()
                        // 格式化 Xml 文件名称
                        .formatXmlFileName("%sMapper")

                        // Service 策略配置
                        .serviceBuilder()
                        // 格式化 service 接口文件名称，%s进行匹配表名，如 UserService
                        .formatServiceFileName("%sService")
                        // 格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl
                        .formatServiceImplFileName("%sServiceImpl")

                        // Controller 策略配置
                        .controllerBuilder()
                        // 格式化 Controller 类文件名称，%s进行匹配表名，如 UserController
                        .formatFileName("%sController")
                        // 开启生成 @RestController 控制器
                        .enableRestStyle()

                        // 实体类策略配置
                        .entityBuilder()
                        .formatFileName("%s")
                        // 开启 Lombok
                        .enableLombok()
                        // 不实现 Serializable 接口，不生成 SerialVersionUID
                        .disableSerialVersionUID()
                        // 逻辑删除字段名
                        .logicDeleteColumnName("deleted")
                        // 乐观锁
                        .versionColumnName("version")
                        // 数据库表映射到实体的命名策略，下划线转驼峰命
                        .naming(NamingStrategy.underline_to_camel)
                        // 数据库表字段映射到实体的命名策略：下划线转驼峰命
                        .columnNaming(NamingStrategy.underline_to_camel)
                        // 自动填充配置,"create_time"字段自动填充为插入时间，"update_time"字段自动填充为插入修改时间
                        .addTableFills(new Column("gmt_create",FieldFill.INSERT),new Column("gmt_modified",FieldFill.INSERT_UPDATE))
                        // 开启生成实体时生成字段注解
                        .enableTableFieldAnnotation()
                )
                // 5.模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                .templateEngine(new VelocityTemplateEngine())
                // 6.执行
                .execute();
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

}
```

## yaml配置

`application.yaml`：

```yaml
# spring
spring:
  # 应用
  application:
    # 名称
    name: ServerBoot
  # 数据源
  datasource:
    # url
    url: jdbc:mysql://127.0.0.1:3306/server_boot
    # 驱动名称
    driver-class-name: com.mysql.cj.jdbc.Driver
    # 用户名
    username: root
    # 密码
    password: 123456
    # hikari数据源
    hikari:
      #连接池名称
      pool-name: Retail_HikariCP
      #最小空闲连接数量
      minimum-idle: 10
      #空闲连接存活最大时间，默认600000（10分钟）
      idle-timeout: 120000
      #连接池最大连接数，默认是10
      maximum-pool-size: 20
      #此属性控制从池返回的连接的默认自动提交行为,默认值：true
      auto-commit: true
      #此属性控制池中连接的最长生命周期，值0表示无限生命周期，默认1800000即30分钟
      max-lifetime: 1800000
      #数据库连接超时时间,默认30秒，即30000
      connection-timeout: 30000
      #配置了这个query则每次拿连接的时候用这个query测试，否则就使用java.sql.Connection的isValid测试  推荐jdbc4不配置。
      connection-test-query: SELECT 1
# mybatis-plus配置
mybatis-plus:
  # 全局配置
  global-config:
    # db配置
    db-config:
      # 全局逻辑删除的实体字段名(since 3.3.0,配置后可以忽略不配置步骤2)
      logic-delete-field: flag
      # 逻辑已删除值(默认为 1)
      logic-delete-value: 1
      # 逻辑未删除值(默认为 0)
      logic-not-delete-value: 0
# 服务
server:
  # 端口
  port:8080
```

