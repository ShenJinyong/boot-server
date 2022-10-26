package com.javaboy.shiro.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.javaboy.system.entity.ServerUser;
import com.javaboy.system.service.ServerUserService;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：Jwt工具类
 * @date ：2022/10/24 9:47
 */
public class JwtUtil {

    // 过期时间30分钟
    private static final long EXPIRE_TIME = 30 * 60 * 1000;
    // 用户名
    private static final String USERNAME = "username";
    // 用户id
    private static final String USER_ID = "userId";
    // 用户头像
    private static final String AVATAR_URL = "avatarUrl";

    /**
     * 生成签名,5min后过期
     * @param username 用户名
     * @param password 用户的密码
     * @return 加密的token
     */
    public static String sign(String username, String password, ServerUser serverUser) {
        Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(password);
        // 附带username信息
        return JWT.create()
                .withClaim(USERNAME, username)
                .withClaim(USER_ID, serverUser.getId())
                .withClaim(AVATAR_URL, serverUser.getAvatarUrl())
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * 校验token是否正确
     * @param token 密钥
     * @param password 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username,String password,ServerUser serverUser) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(USERNAME, username)
                    .withClaim(USER_ID, serverUser.getId())
                    .withClaim(AVATAR_URL, serverUser.getAvatarUrl())
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return false;
        } catch (Exception exception) {
            return true;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(USERNAME).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

}
