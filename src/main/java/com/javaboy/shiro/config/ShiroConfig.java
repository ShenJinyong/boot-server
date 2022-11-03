package com.javaboy.shiro.config;

import com.javaboy.shiro.domain.MyRetryLimitCredentialsMatcher;
import com.javaboy.shiro.domain.UserRealm;
import com.javaboy.shiro.filter.CustomFilter;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
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
        // 关闭shiro自带的session
        DefaultSubjectDAO defaultSubjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        defaultSubjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(defaultSubjectDAO);
        return securityManager;
    }

    // 第三步:创建ShiroFilterFactoryBean
    /*
     * anon:无需认证就可以访问
     * authc:必须认证了才能访问
     * user:必须拥有记住我功能才能用
     * perms:拥有对某个资源的权限才能访问
     * roles:拥有某个角色权限才能访问
     * */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        // 添加过滤器
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);


        LinkedHashMap<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("customFilter",new CustomFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 放行swagger
        filterChainDefinitionMap.put("/swagger-ui/*", "anon");
        filterChainDefinitionMap.put("/v3/api-docs/*", "anon");
        // 从数据库中读出权限和URL
        filterChainDefinitionMap.put("/system/serverUser/register","anon");
        filterChainDefinitionMap.put("/system/serverUser/login","anon");
        filterChainDefinitionMap.put("/system/serverUser/loginSignature","anon");
        filterChainDefinitionMap.put("/system/serverUser/queryAll","anon");
        filterChainDefinitionMap.put("/**","customFilter");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        // 未登录
//        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        // 未授权
//        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        return shiroFilterFactoryBean;
    }

}
