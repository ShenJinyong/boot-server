package com.javaboy.system.controller;


import com.javaboy.common.domain.ResponseEntity;
import com.javaboy.common.enums.AppCode;
import com.javaboy.shiro.domain.CustomToken;
import com.javaboy.shiro.util.EncryptUtil;
import com.javaboy.system.entity.ServerUser;
import com.javaboy.system.service.ServerUserService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-10-17 04:42:44
 */
@RestController
@RequestMapping("/system/serverUser")
public class ServerUserController {

    @Resource
    private ServerUserService serverUserService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestParam(value = "username")String username,
                                   @RequestParam(value = "password")String password) {
        ServerUser serverUser = serverUserService.findByUsername(username);
        if(serverUser != null){
            return ResponseEntity.fail(AppCode.USERNAME_IS_EXISTS);
        }else{
            ServerUser user = new ServerUser();
            user.setUsername(username);
            user.setPassword(EncryptUtil.encrypt(password));
            int flag = serverUserService.createUser(user);
            if(flag == 1){
                return ResponseEntity.ok();
            }else{
                return ResponseEntity.fail(AppCode.INSERT_USER_EXCEPTION);
            }
        }
    }

    @PostMapping("/changePassword")
    public ResponseEntity changePassword(@RequestParam(value = "user_id")String userId,
                                   @RequestParam(value = "password")String password) {
        ServerUser serverUser = serverUserService.getById(userId);
        if(serverUser == null){
            return ResponseEntity.fail(AppCode.NOT_FOUND_USER_BY_ID);
        }else{
            String newPassword = EncryptUtil.encrypt(password);
            if(newPassword.equals(serverUser.getPassword())){
                return ResponseEntity.fail(AppCode.NEW_PASSWORD_SAME_AS_OLD_PASSWORD);
            }else{
                serverUser.setPassword(newPassword);
                boolean flag = serverUserService.updateById(serverUser);
                if(flag){
                    return ResponseEntity.ok();
                }else{
                    return ResponseEntity.fail(AppCode.CHANGE_PASSWORD_EXCEPTION);
                }
            }
        }
    }

    @GetMapping("/login")
    public ResponseEntity<ServerUser> login(@RequestParam(value = "username")String username,
                                            @RequestParam(value = "password")String password){
        // 获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录数据
        CustomToken customToken = new CustomToken(username, password);
        try {
            // 执行登录方法，如果没有异常就说明OK
            subject.login(customToken);
        }catch (UnknownAccountException unknownAccountException){
            return ResponseEntity.fail(AppCode.USERNAME_OR_PASSWORD_ERROR);
        }catch (LockedAccountException lockedAccountException){
            return ResponseEntity.fail(AppCode.LOCKED_ACCOUNT_EXCEPTION);
        }catch (IncorrectCredentialsException incorrectCredentialsException){
            return ResponseEntity.fail(AppCode.USERNAME_OR_PASSWORD_ERROR);
        }catch (ExcessiveAttemptsException excessiveAttemptsException){
            return ResponseEntity.fail(AppCode.EXCESSIVE_ATTEMPTS_EXCEPTION);
        } catch (AuthenticationException e){
            customToken.clear();
            return ResponseEntity.fail(AppCode.USERNAME_OR_PASSWORD_ERROR);
        }
        // 获取返回结果
        ServerUser serverUser = (ServerUser) subject.getSession().getAttribute("user");
        return ResponseEntity.ok(serverUser);
    }

    @GetMapping("/loginSignature")
    @ApiOperation("免密登录")
    public ResponseEntity<ServerUser> loginSignature(@RequestParam(value = "username")String username) {
        Subject subject = SecurityUtils.getSubject();
        CustomToken customToken = new CustomToken(username);
        try {
            // 执行登录方法，如果没有异常就说明OK
            subject.login(customToken);
        }catch (UnknownAccountException unknownAccountException){
            return ResponseEntity.fail(AppCode.USERNAME_OR_PASSWORD_ERROR);
        }catch (LockedAccountException lockedAccountException){
            return ResponseEntity.fail(AppCode.LOCKED_ACCOUNT_EXCEPTION);
        }catch (IncorrectCredentialsException incorrectCredentialsException){
            return ResponseEntity.fail(AppCode.USERNAME_OR_PASSWORD_ERROR);
        }catch (ExcessiveAttemptsException excessiveAttemptsException){
            return ResponseEntity.fail(AppCode.EXCESSIVE_ATTEMPTS_EXCEPTION);
        } catch (AuthenticationException e){
            customToken.clear();
            return ResponseEntity.fail(AppCode.USERNAME_OR_PASSWORD_ERROR);
        }
        // 获取返回结果
        ServerUser serverUser = (ServerUser) subject.getSession().getAttribute("user");
        return ResponseEntity.ok(serverUser);
    }
}

