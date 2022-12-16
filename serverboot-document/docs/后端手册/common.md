# Common

## 应用码

> 定义系统状态接口

```java
public interface SystemStatus {
    // 获取系统状态码
    int getSystemStatusCode();
    // 获取系统状态信息
    public String getSystemStatusMessage();

}
```

> 应用码枚举类

```java
public enum AppCode implements SystemStatus{

    APP_SUCCESS(200, "业务正常"),
    INVALID_PARAM(4000,"参数校验异常"),
    MISTYPE_PARAM(4001,"参数格式异常"),
    MISSING_PARAM(4002,"缺少参数异常"),
    UN_SUPPORTED_METHOD_TYPE(4003,"不支持请求类型"),
    UN_SUPPORTED_METHOD(4004,"不支持请求"),
    SYS_UNKNOWN(4005,"系统异常"),
    UN_LOGIN(4006,"未登录"),
    UN_AUTHORIZED(4007,"未授权"),
    USERNAME_OR_PASSWORD_ERROR(4008,"用户名或者密码错误"),
    NO_PASSWORD_TIMESTAMP_ERROR(4009,"免密时间戳错误"),
    NO_PASSWORD_SIGNATURE_ERROR(4009,"免密签名错误"),
    UN_KNOWN_ACCOUNT_EXCEPTION(4010,"用户名不存在异常"),
    REPEAT_KNOWN_ACCOUNT_EXCEPTION(4011,"用户名不唯一"),
    APP_ERROR(400, "业务异常");

    private int code;
    private String message;

    AppCode(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    @Override
    public int getSystemStatusCode() {
        return code;
    }

    @Override
    public String getSystemStatusMessage() {
        return message;
    }
}
```

## 服务异常

> 自定义服务异常

```java
public class ServiceException extends RuntimeException{

    private static final long serialVersionUID = -7864604160297181941L;
    private int code;
    private String message;

    public ServiceException(AppCode appCode) {
        this.code = appCode.getSystemStatusCode();
        this.message = appCode.getSystemStatusMessage();
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
```

## 响应实体类

```java
@Data
@ApiModel(description = "响应实体类")
public class ResponseEntity<T> {

    private static final long serialVersionUID = -1L;
    private boolean success;
    private T data;
    private int code;
    private String message;

    private ResponseEntity(boolean success, T data, AppCode appCode) {
        this.success = success;
        this.data = data;
        this.code = appCode.getSystemStatusCode();
        this.message = appCode.getSystemStatusMessage();
    }

    private ResponseEntity(boolean success, T data, int code, String message) {
        this.success = success;
        this.data = data;
        this.code = code;
        this.message = message;
    }

    /**
     * 成功返回
     */
    public static <T> ResponseEntity<T> ok(T data) {
        return new ResponseEntity<>(Boolean.TRUE, data, AppCode.APP_SUCCESS);
    }

    /**
     * 异常返回-指定错误码
     */
    public static ResponseEntity fail(AppCode appCode) {
        return new ResponseEntity(Boolean.FALSE, null, appCode);
    }

    /**
     * 自定义业务异常返回
     */
    public static ResponseEntity fail(ServiceException serviceException) {
        return new ResponseEntity(Boolean.FALSE, null, serviceException.getCode(),serviceException.getMessage());
    }

}
```

## 统一响应处理

```java
@Slf4j
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    @Resource
    HttpServletRequest httpServletRequest;

    @Override
    public boolean supports(@NonNull MethodParameter methodParameter,@NonNull Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  @NonNull MethodParameter returnType,
                                  @NonNull MediaType selectedContentType,
                                  @NonNull Class selectedConverterType,
                                  ServerHttpRequest request,
                                  @NonNull ServerHttpResponse response) {

        // 拦截swagger相关请求
        if(request.getURI().getPath().contains("swagger-ui") || request.getURI().getPath().contains("api-docs")){
            return body;
        }

        // 返回对象封装
        if (body instanceof ResponseEntity) {
            // 被exceptionHandler处理过了，直接返回
            return body;
        }else if (body instanceof String){
            // 处理String类型，否则会出现类型转换错误String=>ResponseEntity，直接返回
            return body;
        }else {
            return ResponseEntity.ok(body);
        }

    }

    /**
     * 异常日志记录
     */
    private void logErrorRequest(Exception e) {
        log.error("报错API URL:{}", httpServletRequest.getRequestURL().toString());
        log.error("异常:{}", e.getMessage());
    }

    /**
     * 参数未通过@Valid验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    private ResponseEntity methodArgumentNotValid(MethodArgumentNotValidException exception) {
        logErrorRequest(exception);
        return ResponseEntity.fail(AppCode.INVALID_PARAM);
    }

    /**
     * 参数格式有误
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class})
    @ResponseBody
    private ResponseEntity typeMismatch(Exception exception) {
        logErrorRequest(exception);
        return ResponseEntity.fail(AppCode.MISTYPE_PARAM);
    }

    /**
     * 缺少参数
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    private ResponseEntity missingServletRequestParameter(MissingServletRequestParameterException exception) {
        logErrorRequest(exception);
        return ResponseEntity.fail(AppCode.MISSING_PARAM);
    }

    /**
     * 不支持的请求类型
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    private ResponseEntity httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception) {
        logErrorRequest(exception);
        return ResponseEntity.fail(AppCode.UN_SUPPORTED_METHOD_TYPE);
    }

    /**
     * 不支持的请求
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    private ResponseEntity noHandlerFoundException(NoHandlerFoundException exception) {
        logErrorRequest(exception);
        return ResponseEntity.fail(AppCode.UN_SUPPORTED_METHOD);
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    private ResponseEntity serviceExceptionHandler(ServiceException serviceException) {
        logErrorRequest(serviceException);
        return ResponseEntity.fail(serviceException);
    }

    /**
     * 其他异常
     */
    @ExceptionHandler({HttpClientErrorException.class, IOException.class, Exception.class})
    @ResponseBody
    private ResponseEntity commonExceptionHandler(Exception exception) {
        logErrorRequest(exception);
        return ResponseEntity.fail(AppCode.SYS_UNKNOWN);
    }

}
```

