import { ssrRenderAttrs, ssrRenderStyle } from "vue/server-renderer";
import { useSSRContext } from "vue";
import { _ as _export_sfc } from "./plugin-vue_export-helper.6ab74304.js";
const __pageData = JSON.parse('{"title":"Nginx","description":"","frontmatter":{},"headers":[{"level":2,"title":"\u76EE\u5F55","slug":"\u76EE\u5F55","link":"#\u76EE\u5F55","children":[]},{"level":2,"title":"\u57FA\u672C\u64CD\u4F5C","slug":"\u57FA\u672C\u64CD\u4F5C","link":"#\u57FA\u672C\u64CD\u4F5C","children":[]},{"level":2,"title":"\u57FA\u672C\u914D\u7F6E","slug":"\u57FA\u672C\u914D\u7F6E","link":"#\u57FA\u672C\u914D\u7F6E","children":[]},{"level":2,"title":"KeyTool","slug":"keytool","link":"#keytool","children":[]},{"level":2,"title":"HTTPS\u914D\u7F6E","slug":"https\u914D\u7F6E","link":"#https\u914D\u7F6E","children":[]},{"level":2,"title":"\u5F3A\u5236\u8F6C\u6362","slug":"\u5F3A\u5236\u8F6C\u6362","link":"#\u5F3A\u5236\u8F6C\u6362","children":[]},{"level":2,"title":"\u6269\u5C55","slug":"\u6269\u5C55","link":"#\u6269\u5C55","children":[]}],"relativePath":"\u540E\u7AEF\u624B\u518C/Nginx.md","lastUpdated":1666352726000}');
const _sfc_main = { name: "\u540E\u7AEF\u624B\u518C/Nginx.md" };
function _sfc_ssrRender(_ctx, _push, _parent, _attrs, $props, $setup, $data, $options) {
  _push(`<div${ssrRenderAttrs(_attrs)}><h1 id="nginx" tabindex="-1">Nginx <a class="header-anchor" href="#nginx" aria-hidden="true">#</a></h1><p><code>nginx</code>\u5B98\u7F51\uFF1A<code>https://nginx.org/</code></p><p><code>nginx</code>\u4E0B\u8F7D\u5730\u5740\uFF1A<code>https://nginx.org/en/download.html</code></p><h2 id="\u76EE\u5F55" tabindex="-1">\u76EE\u5F55 <a class="header-anchor" href="#\u76EE\u5F55" aria-hidden="true">#</a></h2><ul><li>conf \u914D\u7F6E</li><li>contrib</li><li>docs \u6587\u6863</li><li>html \u9759\u6001\u6587\u4EF6</li><li>logs \u65E5\u5FD7</li><li>temp \u4E34\u65F6\u6587\u4EF6</li><li>nginx.exe</li></ul><h2 id="\u57FA\u672C\u64CD\u4F5C" tabindex="-1">\u57FA\u672C\u64CD\u4F5C <a class="header-anchor" href="#\u57FA\u672C\u64CD\u4F5C" aria-hidden="true">#</a></h2><p>\u542F\u52A8nginx</p><div class="language-sh"><button class="copy"></button><span class="lang">sh</span><pre><code><span class="line"><span style="${ssrRenderStyle({ "color": "#616E88" })}"># windows\u547D\u4EE4\uFF0C\u4E00\u95EA\u800C\u8FC7</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">start nginx</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#616E88" })}"># linux</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">nginx</span></span>
<span class="line"></span></code></pre></div><p>\u505C\u6B62nginx</p><div class="language-sh"><button class="copy"></button><span class="lang">sh</span><pre><code><span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">nginx -s stop</span></span>
<span class="line"></span></code></pre></div><p>\u91CD\u65B0\u52A0\u8F7D\u914D\u7F6E\u6587\u4EF6</p><div class="language-sh"><button class="copy"></button><span class="lang">sh</span><pre><code><span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">nginx -s reload</span></span>
<span class="line"></span></code></pre></div><p>\u9000\u51FAnginx</p><div class="language-sh"><button class="copy"></button><span class="lang">sh</span><pre><code><span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">nginx -s quit</span></span>
<span class="line"></span></code></pre></div><p>\u68C0\u6D4Bnginx\u7684\u914D\u7F6E\u6587\u4EF6\u662F\u5426\u6B63\u786E</p><div class="language-sh"><button class="copy"></button><span class="lang">sh</span><pre><code><span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">nginx -t</span></span>
<span class="line"></span></code></pre></div><h2 id="\u57FA\u672C\u914D\u7F6E" tabindex="-1">\u57FA\u672C\u914D\u7F6E <a class="header-anchor" href="#\u57FA\u672C\u914D\u7F6E" aria-hidden="true">#</a></h2><div class="language-"><button class="copy"></button><span class="lang"></span><pre><code><span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">#user  nobody;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">worker_processes  1;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">#error_log  logs/error.log;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">#error_log  logs/error.log  notice;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">#error_log  logs/error.log  info;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">#pid        logs/nginx.pid;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">events {</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    worker_connections  1024;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">}</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">http {</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    include       mime.types;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    default_type  application/octet-stream;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #log_format  main  &#39;$remote_addr - $remote_user [$time_local] &quot;$request&quot; &#39;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #                  &#39;$status $body_bytes_sent &quot;$http_referer&quot; &#39;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #                  &#39;&quot;$http_user_agent&quot; &quot;$http_x_forwarded_for&quot;&#39;;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #access_log  logs/access.log  main;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    sendfile        on;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #tcp_nopush     on;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #keepalive_timeout  0;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    keepalive_timeout  65;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #gzip  on;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    server {</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        listen       80;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        server_name  localhost;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #charset koi8-r;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #access_log  logs/host.access.log  main;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        location / {</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">            root   html;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">            index  index.html index.htm;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        }</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #error_page  404              /404.html;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        # redirect server error pages to the static page /50x.html</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        error_page   500 502 503 504  /50x.html;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        location = /50x.html {</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">            root   html;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        }</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        # proxy the PHP scripts to Apache listening on 127.0.0.1:80</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #location ~ \\.php$ {</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #    proxy_pass   http://127.0.0.1;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #}</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        # pass the PHP scripts to FastCGI server listening on 127.0.0.1:9000</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #location ~ \\.php$ {</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #    root           html;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #    fastcgi_pass   127.0.0.1:9000;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #    fastcgi_index  index.php;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #    fastcgi_param  SCRIPT_FILENAME  /scripts$fastcgi_script_name;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #    include        fastcgi_params;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #}</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        # deny access to .htaccess files, if Apache&#39;s document root</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        # concurs with nginx&#39;s one</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #location ~ /\\.ht {</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #    deny  all;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        #}</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    }</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    # another virtual host using mix of IP-, name-, and port-based configuration</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #server {</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #    listen       8000;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #    listen       somename:8080;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #    server_name  somename  alias  another.alias;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #    location / {</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #        root   html;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #        index  index.html index.htm;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #    }</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #}</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    # HTTPS server</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #server {</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #    listen       443 ssl;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #    server_name  localhost;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #    ssl_certificate      cert.pem;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #    ssl_certificate_key  cert.key;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #    ssl_session_cache    shared:SSL:1m;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #    ssl_session_timeout  5m;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #    ssl_ciphers  HIGH:!aNULL:!MD5;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #    ssl_prefer_server_ciphers  on;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #    location / {</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #        root   html;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #        index  index.html index.htm;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #    }</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    #}</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">}</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span></code></pre></div><p>\u8BF4\u660E\uFF1A</p><ul><li>worker_processes \u5DE5\u4F5C\u8FDB\u7A0B</li><li>events \u4E8B\u4EF6\u914D\u7F6E</li><li>http \u6A21\u5757 <ul><li>server\u865A\u62DF\u670D\u52A1\u5668\u8282\u70B9</li></ul></li></ul><h2 id="keytool" tabindex="-1">KeyTool <a class="header-anchor" href="#keytool" aria-hidden="true">#</a></h2><p>KeyTool\u662F\u5BC6\u94A5\u548C\u8BC1\u4E66\u7BA1\u7406\u5DE5\u5177\u3002</p><p>\u73B0\u5728\u5927\u591A\u6570\u4F7F\u7528\u7684\u662F<code>Spring Boot</code>\uFF0C\u4F5C\u4E3A\u5F00\u53D1\u7684\u57FA\u7840\uFF0C\u5BF9\u4E8E\u4E00\u4E2A<code>Java</code>\u7684\u9879\u76EE\uFF0C\u4E00\u822C\u4F7F\u7528\u7684\u8BC1\u4E66\u662F<code>JKS</code>\u8BC1\u4E66\u3010JDK1.7\u4E4B\u524D\u3011\u6216\u8005\u662F<code>PCKS12</code>\u8BC1\u4E66\u3010JDK1.8\u4E4B\u540E\u3011\u3002</p><p>\u5982\u679C\u8981\u4F7F\u7528<code>Nginx</code>\u6765\u5F00\u542F<code>SSL</code>\uFF0C\u5F53\u6211\u4EEC\u9700\u8981\u81EA\u5DF1\u5236\u4F5C\u8BC1\u4E66\u7684\u65F6\u5019\uFF0C\u5C31\u9700\u8981\u628A<code>JKS</code>\u8BC1\u4E66\u8F6C\u6362\u6210<code>PCKS12</code>\u7684\u683C\u5F0F\uFF0C\u7136\u540E\u901A\u8FC7<code>OpenSSL</code>\u63D0\u53D6\u8BC1\u4E66\u548C\u79C1\u94A5\uFF0C\u9700\u8981\u8BC1\u4E66\u662F<code>.crt</code>\u548C\u79C1\u94A5<code>.key</code>\u3002</p><blockquote><p>\u751F\u6210JKS\u683C\u5F0F\u5BC6\u94A5\u5E93</p></blockquote><div class="language-sh"><button class="copy"></button><span class="lang">sh</span><pre><code><span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">keytool -genkeypair -alias springcert -keyalg RSA -keysize 2048 -keypass 123456 -validity 3650 -keystore d:</span><span style="${ssrRenderStyle({ "color": "#EBCB8B" })}">\\s</span><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">pringcert.jks -storepass 123456</span></span>
<span class="line"></span></code></pre></div><p>\u53C2\u6570\u8BF4\u660E\uFF1A</p><ul><li>genkeypair \u751F\u6210\u5BC6\u94A5\u5BF9 <ul><li>alias \u8981\u5904\u7406\u7684\u6761\u76EE\u7684\u522B\u540D</li><li>keyalg \u52A0\u5BC6\u7B97\u6CD5\u540D\u79F0</li><li>keysize \u5BC6\u94A5\u4F4D\u5927\u5C0F</li><li>keypass \u5BC6\u94A5\u53E3\u4EE4</li><li>validity \u6709\u6548\u5929\u6570</li><li>ketstore \u5BC6\u94A5\u5E93\u540D\u79F0</li><li>storepass \u5BC6\u94A5\u5E93\u53E3\u4EE4</li></ul></li></ul><blockquote><p>\u5C06JKS\u5BC6\u94A5\u5E93\u8F6C\u4E3AP12\u5BC6\u94A5\u5E93</p></blockquote><div class="language-sh"><button class="copy"></button><span class="lang">sh</span><pre><code><span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">keytool -importkeystore -srckeystore d:</span><span style="${ssrRenderStyle({ "color": "#EBCB8B" })}">\\s</span><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">pringcert.jks -srcalias tomcat -destkeystore d:</span><span style="${ssrRenderStyle({ "color": "#EBCB8B" })}">\\s</span><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">pringcert.p12 -deststoretype PKCS12</span></span>
<span class="line"></span></code></pre></div><ul><li>importkeystore \u5BFC\u5165\u8BC1\u4E66\u6216\u8BC1\u4E66\u94FE</li></ul><blockquote><p>OpenSSL</p></blockquote><p>\u4F7F\u7528<code>git</code>\u7684<code>git bash</code></p><div class="language-sh"><button class="copy"></button><span class="lang">sh</span><pre><code><span class="line"><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u8FDB\u5165ssl</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">openssl</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u9000\u51FAssl</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#88C0D0" })}">exit</span></span>
<span class="line"></span></code></pre></div><blockquote><p>OpenSSL\u63D0\u53D6\u8BC1\u4E66\u548C\u5BC6\u94A5</p></blockquote><div class="language-sh"><button class="copy"></button><span class="lang">sh</span><pre><code><span class="line"><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u751F\u6210\u8BC1\u4E66</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">openssl pkcs12 -in d:</span><span style="${ssrRenderStyle({ "color": "#EBCB8B" })}">\\s</span><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">pringcert.p12 -nokeys -clcerts -out d:</span><span style="${ssrRenderStyle({ "color": "#EBCB8B" })}">\\s</span><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">perngcert.crt</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u751F\u6210\u5BC6\u94A5</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">openssl pkcs12 -in d:</span><span style="${ssrRenderStyle({ "color": "#EBCB8B" })}">\\s</span><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">pringcert.p12 -nocerts -nodes -out d:</span><span style="${ssrRenderStyle({ "color": "#EBCB8B" })}">\\s</span><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">pringcert.key</span></span>
<span class="line"></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#616E88" })}"># windows\u73AF\u5883\u4E0B\uFF0C\u4F1A\u51FA\u73B0\u5361\u4F4F\u7684\u60C5\u51B5\uFF0C\u53EF\u4EE5\u5C1D\u8BD5\u5728openssl\u7684\u524D\u9762\u6DFB\u52A0winpty</span></span>
<span class="line"></span></code></pre></div><h2 id="https\u914D\u7F6E" tabindex="-1">HTTPS\u914D\u7F6E <a class="header-anchor" href="#https\u914D\u7F6E" aria-hidden="true">#</a></h2><div class="language-"><button class="copy"></button><span class="lang"></span><pre><code><span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"># HTTPS server</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">server {</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    listen       443 ssl;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    server_name  localhost;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    ssl_certificate      cert.pem;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    ssl_certificate_key  cert.key;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    ssl_session_cache    shared:SSL:1m;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    ssl_session_timeout  5m;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    ssl_ciphers  HIGH:!aNULL:!MD5;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    ssl_prefer_server_ciphers  on;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    location / {</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        root   html;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">        index  index.html index.htm;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">    }</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">}</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span></code></pre></div><p>\u53C2\u6570\u8BF4\u660E\uFF1A</p><ul><li><p>listen \u76D1\u542C\u7AEF\u53E3</p></li><li><p>server_name ip\u6216\u57DF\u540D</p></li><li><p>ssl_certficate \u8BC1\u4E66\u4F4D\u7F6E</p></li><li><p>ssl_certificate_key \u5BC6\u94A5\u4F4D\u7F6E</p></li></ul><h2 id="\u5F3A\u5236\u8F6C\u6362" tabindex="-1">\u5F3A\u5236\u8F6C\u6362 <a class="header-anchor" href="#\u5F3A\u5236\u8F6C\u6362" aria-hidden="true">#</a></h2><p>\u5728\u76D1\u542C80\u7AEF\u53E3\u65F6\u6DFB\u52A0</p><div class="language-"><button class="copy"></button><span class="lang"></span><pre><code><span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}">return 301 https://localhost$request_uri;</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#d8dee9ff" })}"></span></span></code></pre></div><h2 id="\u6269\u5C55" tabindex="-1">\u6269\u5C55 <a class="header-anchor" href="#\u6269\u5C55" aria-hidden="true">#</a></h2><p>DNS Name = loclahost</p><p>IP Address = 127.0.0.1</p></div>`);
}
const _sfc_setup = _sfc_main.setup;
_sfc_main.setup = (props, ctx) => {
  const ssrContext = useSSRContext();
  (ssrContext.modules || (ssrContext.modules = /* @__PURE__ */ new Set())).add("\u540E\u7AEF\u624B\u518C/Nginx.md");
  return _sfc_setup ? _sfc_setup(props, ctx) : void 0;
};
const Nginx = /* @__PURE__ */ _export_sfc(_sfc_main, [["ssrRender", _sfc_ssrRender]]);
export {
  __pageData,
  Nginx as default
};
