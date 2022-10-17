package com.javaboy.shiro.domain;

import com.javaboy.shiro.enums.LoginType;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：Shiro编码加密
 * @date ：2022/10/14 15:08
 */
@Slf4j
public class MyRetryLimitCredentialsMatcher extends SimpleCredentialsMatcher {

    // 集群中可能会导致出现验证多过5次的现象，因为AtomicInteger只能保证单节点并发
    private Cache<String, AtomicInteger> passwordRetryCache;
    private static final String RETRY_CACHE_NAME = "passwordRetryCache";

    public MyRetryLimitCredentialsMatcher(EhCacheManager cacheManager) {
        /**
         * 此处从CacheManager中获取缓存Cache对象
         * 本例中获取的缓存对象是从Ehcache.xml配置中获取
         * 如果是我们自定义CacheManager的话，
         * 可用下面的实现思路：
         * 先尝试从缓区池中获取名为RETRY_CACHE_NAME的缓存对象
         * 如果缓存池中没有名为RETRY_CACHE_NAME的缓存对象
         * 那么则创建名为RETRY_CACHE_NAME的缓存对象，并放入到缓存池中
         * 保证本类属性passwordRetryCache不为空
         */
        passwordRetryCache = cacheManager.getCache(RETRY_CACHE_NAME);
    }


    // 匹配用户输入的token的凭证（未加密）与系统提供的凭证（已加密）
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        // 获取用户名
        String username = (String) authcToken.getPrincipal();
        // retry count + 1
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if(retryCount == null) {
            retryCount = new AtomicInteger(0);
        }
        // 登录次数加1
        retryCount.incrementAndGet();

        // if retry count > 5 throw
        if(retryCount.get() > 5) {
            throw new ExcessiveAttemptsException();
        }
        // 并将其保存到缓存中
        passwordRetryCache.put(username, retryCount);
        // 处理客户端Token
        if (authcToken instanceof CustomToken) {
            CustomToken customToken = (CustomToken) authcToken;
            // 处理免密登录,放行
            if (customToken.getLoginType().equals(LoginType.NO_PASSWORD)) {
                // clear retry count
                passwordRetryCache.remove(username);
                return true;
            }
        }
        // 调用超类验证器，判断是否登录成功
        boolean matches = super.doCredentialsMatch(authcToken, info);
        if(matches) {
            // clear retry count
            passwordRetryCache.remove(username);
        }
        return matches;
    }
}
