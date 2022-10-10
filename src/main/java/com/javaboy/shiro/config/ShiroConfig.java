package com.javaboy.shiro.config;

import com.javaboy.shiro.filter.AuthorizationFilter;
import com.javaboy.shiro.filter.LoginFilter;
import com.javaboy.shiro.util.MyRetryLimitCredentialsMatcher;
import com.javaboy.shiro.util.UserRealm;
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
 * @date ：2022/9/27 10:27
 */
@Configuration
public class ShiroConfig {

    // 第一步:创建realm对象，需要自定义
    @Bean
    public UserRealm userRealm(MyRetryLimitCredentialsMatcher matcher){
        UserRealm userRealm = new UserRealm();
        // 自定义密码匹配凭证管理器
        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }

    // 第二步:创建DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("codLimitCredentialsMatcher") MyRetryLimitCredentialsMatcher matcher){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联UserRealm
        securityManager.setRealm(userRealm(matcher));
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
         * role:拥有某个角色权限才能访问
         * */
        // 使用Shiro的内置过滤器
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // swagger
        filterChainDefinitionMap.put("/swagger-ui/*", "anon");
        filterChainDefinitionMap.put("/v3/api-docs/*", "anon");
        // 从数据库中读出权限和URL
        filterChainDefinitionMap.put("/shiro/serverUser/login","anon");
        filterChainDefinitionMap.put("/shiro/serverUser/register","anon");
        filterChainDefinitionMap.put("/shiro/serverUser/loginOut","authc");
        filterChainDefinitionMap.put("/shiro/serverUser/delete","authc");
        filterChainDefinitionMap.put("/shiro/serverUser/update","authc");
        filterChainDefinitionMap.put("/shiro/serverUser/queryOne","authc");
        filterChainDefinitionMap.put("/shiro/serverUser/queryAll","roles[admin]");
        filterChainDefinitionMap.put("/test/perms","perms[user:add]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        // 使用自定义的过滤器
        LinkedHashMap<String, Filter> filters = new LinkedHashMap<>();
        // 未登录 shiroFilterFactoryBean.setLoginUrl("/toLogin");
        filters.put("authc", new LoginFilter());
        // 未授权 shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        filters.put("perms", new AuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filters);

        return shiroFilterFactoryBean;
    }

    // 自定义密码匹配凭证管理器
    @Bean(name = "codLimitCredentialsMatcher")
    public MyRetryLimitCredentialsMatcher hashedCredentialsMatcher() {
        return new MyRetryLimitCredentialsMatcher();
    }

}
