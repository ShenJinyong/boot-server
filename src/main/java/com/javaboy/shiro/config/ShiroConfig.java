package com.javaboy.shiro.config;

import com.javaboy.shiro.service.impl.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public UserRealm userRealm(){
        return new UserRealm();
    }

    // 第二步:创建DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // 第三步:创建ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        // 添加Shiro的内置过滤器
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        // 授权，正常的情况下，没有授权跳转到未授权页面
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/*","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        // 设置登录的请求
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        // 未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        return shiroFilterFactoryBean;
    }

    /*
     * anon:无需认证就可以访问
     * authc:必须认证了才能访问
     * user:必须拥有 记住我功能才能用
     * perms:拥有对某个资源的权限才能访问
     * role:拥有某个角色权限才能访问
     * */

}
