package com.javaboy.system.controller;


import com.javaboy.common.domain.ResponseEntity;
import com.javaboy.common.enums.AppCode;
import com.javaboy.shiro.domain.CustomToken;
import com.javaboy.shiro.util.EncryptUtil;
import com.javaboy.shiro.util.JwtUtil;
import com.javaboy.system.entity.ServerUser;
import com.javaboy.system.service.ServerUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-10-17 04:42:44
 */
@Tag(name = "用户模块")
@RestController
@RequestMapping("/system/serverUser")
public class ServerUserController {

    @Resource
    private ServerUserService serverUserService;

    @PostMapping("/list")
    @Operation(summary = "用户管理")
    public ResponseEntity<List<ServerUser>> list() {
        List<ServerUser> serverUserList = serverUserService.list();
        return ResponseEntity.ok(serverUserList);
    }

    @PostMapping("/add")
    @Operation(summary = "用户新增")
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

    @GetMapping("/query")
    @Operation(summary = "用户查询")
    public ResponseEntity<ServerUser> query(@RequestParam(value = "id")String id) {
        ServerUser user = serverUserService.getById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/edit")
    @Operation(summary = "用户修改")
    public ResponseEntity edit(@RequestBody ServerUser serverUser) {
        boolean flag = serverUserService.updateById(serverUser);
        if(flag){
            return ResponseEntity.ok();
        }else{
            return ResponseEntity.fail(AppCode.CHANGE_USER_EXCEPTION);
        }
    }

    @GetMapping("/delete")
    @Operation(summary = "用户删除")
    public ResponseEntity delete(@RequestParam(value = "id")String id) {
        boolean flag = serverUserService.removeById(id);
        if(flag){
            return ResponseEntity.ok();
        }else{
            return ResponseEntity.fail(AppCode.DELETE_USER_EXCEPTION);
        }
    }

    @GetMapping("/login")
    @Operation(summary = "登录")
    public ResponseEntity<String> login(@RequestParam(value = "username")String username,
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
        String sign = JwtUtil.sign(username,EncryptUtil.encrypt(password));
        return ResponseEntity.ok(sign);
    }

    @GetMapping("/loginSignature")
    @Operation(summary = "免密登录")
    public ResponseEntity<String> loginSignature(@RequestParam(value = "username")String username) {
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
        String sign = JwtUtil.sign(username);
        return ResponseEntity.ok(sign);
    }

    @GetMapping("/loginOut")
    @Operation(summary = "登出")
    public ResponseEntity<ServerUser> loginOut(@RequestParam(value = "username")String username){
        return ResponseEntity.ok();
    }

    @PostMapping("/changePassword")
    @Operation(summary = "修改密码")
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
}

