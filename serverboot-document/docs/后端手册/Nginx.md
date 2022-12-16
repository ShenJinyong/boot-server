# Nginx

`nginx`官网：`https://nginx.org/`

`nginx`下载地址：`https://nginx.org/en/download.html`

## 目录

- conf 配置
- contrib
- docs 文档
- html 静态文件
- logs 日志
- temp 临时文件
- nginx.exe

## 基本操作

启动nginx

```sh
# windows命令，一闪而过
start nginx
# linux
nginx
```

停止nginx

```sh
nginx -s stop
```

重新加载配置文件

```sh
nginx -s reload
```

退出nginx

```sh
nginx -s quit
```

检测nginx的配置文件是否正确

```sh
nginx -t
```

## 基本配置

```
#user  nobody;
worker_processes  1;

#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;

#pid        logs/nginx.pid;


events {
    worker_connections  1024;
}


http {
    include       mime.types;
    default_type  application/octet-stream;

    #log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
    #                  '$status $body_bytes_sent "$http_referer" '
    #                  '"$http_user_agent" "$http_x_forwarded_for"';

    #access_log  logs/access.log  main;

    sendfile        on;
    #tcp_nopush     on;

    #keepalive_timeout  0;
    keepalive_timeout  65;

    #gzip  on;

    server {
        listen       80;
        server_name  localhost;

        #charset koi8-r;

        #access_log  logs/host.access.log  main;

        location / {
            root   html;
            index  index.html index.htm;
        }

        #error_page  404              /404.html;

        # redirect server error pages to the static page /50x.html
        #
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }

        # proxy the PHP scripts to Apache listening on 127.0.0.1:80
        #
        #location ~ \.php$ {
        #    proxy_pass   http://127.0.0.1;
        #}

        # pass the PHP scripts to FastCGI server listening on 127.0.0.1:9000
        #
        #location ~ \.php$ {
        #    root           html;
        #    fastcgi_pass   127.0.0.1:9000;
        #    fastcgi_index  index.php;
        #    fastcgi_param  SCRIPT_FILENAME  /scripts$fastcgi_script_name;
        #    include        fastcgi_params;
        #}

        # deny access to .htaccess files, if Apache's document root
        # concurs with nginx's one
        #
        #location ~ /\.ht {
        #    deny  all;
        #}
    }


    # another virtual host using mix of IP-, name-, and port-based configuration
    #
    #server {
    #    listen       8000;
    #    listen       somename:8080;
    #    server_name  somename  alias  another.alias;

    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}


    # HTTPS server
    #
    #server {
    #    listen       443 ssl;
    #    server_name  localhost;

    #    ssl_certificate      cert.pem;
    #    ssl_certificate_key  cert.key;

    #    ssl_session_cache    shared:SSL:1m;
    #    ssl_session_timeout  5m;

    #    ssl_ciphers  HIGH:!aNULL:!MD5;
    #    ssl_prefer_server_ciphers  on;

    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}

}

```

说明：

- worker_processes 工作进程
- events 事件配置
- http 模块
  - server虚拟服务器节点

## KeyTool

KeyTool是密钥和证书管理工具。

现在大多数使用的是`Spring Boot`，作为开发的基础，对于一个`Java`的项目，一般使用的证书是`JKS`证书【JDK1.7之前】或者是`PCKS12`证书【JDK1.8之后】。

如果要使用`Nginx`来开启`SSL`，当我们需要自己制作证书的时候，就需要把`JKS`证书转换成`PCKS12`的格式，然后通过`OpenSSL`提取证书和私钥，需要证书是`.crt`和私钥`.key`。

> 生成JKS格式密钥库

```sh
keytool -genkeypair -alias springcert -keyalg RSA -keysize 2048 -keypass 123456 -validity 3650 -keystore d:\springcert.jks -storepass 123456
```

参数说明：

- genkeypair 生成密钥对
  - alias 要处理的条目的别名
  - keyalg 加密算法名称
  - keysize 密钥位大小
  - keypass 密钥口令
  - validity 有效天数
  - ketstore 密钥库名称
  - storepass 密钥库口令

> 将JKS密钥库转为P12密钥库

```sh
keytool -importkeystore -srckeystore d:\springcert.jks -srcalias tomcat -destkeystore d:\springcert.p12 -deststoretype PKCS12
```

- importkeystore 导入证书或证书链

> OpenSSL

使用`git`的`git bash`

```sh
# 进入ssl
openssl
# 退出ssl
exit
```

>OpenSSL提取证书和密钥

```sh
# 生成证书
openssl pkcs12 -in d:\springcert.p12 -nokeys -clcerts -out d:\sperngcert.crt
# 生成密钥
openssl pkcs12 -in d:\springcert.p12 -nocerts -nodes -out d:\springcert.key

# windows环境下，会出现卡住的情况，可以尝试在openssl的前面添加winpty
```

## HTTPS配置

```
# HTTPS server
server {
    listen       443 ssl;
    server_name  localhost;

    ssl_certificate      cert.pem;
    ssl_certificate_key  cert.key;

    ssl_session_cache    shared:SSL:1m;
    ssl_session_timeout  5m;

    ssl_ciphers  HIGH:!aNULL:!MD5;
    ssl_prefer_server_ciphers  on;

    location / {
        root   html;
        index  index.html index.htm;
    }
}
```

参数说明：

- listen 监听端口
- server_name ip或域名

- ssl_certficate 证书位置
- ssl_certificate_key 密钥位置

## 强制转换

在监听80端口时添加

```
return 301 https://localhost$request_uri;
```

## 扩展

DNS Name = loclahost

IP Address = 127.0.0.1

