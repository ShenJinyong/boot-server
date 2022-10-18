package com.javaboy.shiro.config;

import com.javaboy.shiro.domain.MyRetryLimitCredentialsMatcher;
import com.javaboy.shiro.domain.UserRealm;
import com.javaboy.shiro.filter.MyBasicHttpAuthenticationFilter;
import com.javaboy.shiro.filter.MyPermissionsAuthorizationFilter;
import com.javaboy.shiro.filter.MyAuthenticationFilter;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：Shiro配置类
 * @date ：2022/10/14 15:10
 */
@Configuration
public class ShiroConfig {

    // 自定义密码匹配凭证管理器
    @Bean(name = "codLimitCredentialsMatcher")
    public MyRetryLimitCredentialsMatcher hashedCredentialsMatcher() {
        return new MyRetryLimitCredentialsMatcher(getEhCacheManager());
    }

    // 缓存管理对象
    @Bean
    public EhCacheManager getEhCacheManager(){
        EhCacheManager ehCacheManager = new EhCacheManager();
        // 配置缓存管理器对象
        ehCacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        return ehCacheManager;
    }

    // 第一步:创建realm对象
    @Bean
    public UserRealm userRealm(MyRetryLimitCredentialsMatcher matcher){
        // 创建自定义域实例
        UserRealm userRealm = new UserRealm();
        // 域实例绑定自定义密码匹配凭证管理器
        userRealm.setCredentialsMatcher(matcher);
        // 返回域实例
        return userRealm;
    }

    // 第二步:创建DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("codLimitCredentialsMatcher") MyRetryLimitCredentialsMatcher matcher){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联UserRealm
        securityManager.setRealm(userRealm(matcher));
        // 给安全管理器设置缓存管理器对象
        securityManager.setCacheManager(getEhCacheManager());
        return securityManager;
    }

    // 第三步:创建ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        // 添加过滤器
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        /*
         * anon:无需认证就可以访问
         * authc:必须认证了才能访问
         * user:必须拥有记住我功能才能用
         * perms:拥有对某个资源的权限才能访问
         * roles:拥有某个角色权限才能访问
         * */
        // 使用Shiro的内置过滤器
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 放行swagger
        filterChainDefinitionMap.put("/swagger-ui/*", "anon");
        filterChainDefinitionMap.put("/v3/api-docs/*", "anon");
        // 从数据库中读出权限和URL
        filterChainDefinitionMap.put("/system/serverUser/register","anon");
        filterChainDefinitionMap.put("/system/serverUser/login","anon");
        filterChainDefinitionMap.put("/system/serverUser/loginSignature","anon");
        filterChainDefinitionMap.put("/system/serverUser/queryAll","anon");
        filterChainDefinitionMap.put("/system/serverUser/loginOut","authc");
        filterChainDefinitionMap.put("/system/serverUser/changePassword","authc");
        filterChainDefinitionMap.put("/system/serverUser/query","authc");
        filterChainDefinitionMap.put("/system/serverUser/add","perms[user:add]");
        filterChainDefinitionMap.put("/system/serverUser/ad","roles[admin]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        // 使用自定义的过滤器
        LinkedHashMap<String, Filter> filters = new LinkedHashMap<>();
        // 未登录 shiroFilterFactoryBean.setLoginUrl("/toLogin");
        filters.put("authc", new MyAuthenticationFilter());
        // 未授权 shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        filters.put("perms", new MyPermissionsAuthorizationFilter());
        // Basic HTTP 身份验证拦截器
        filters.put("authcBasic",new MyBasicHttpAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(filters);

        return shiroFilterFactoryBean;
    }



}
