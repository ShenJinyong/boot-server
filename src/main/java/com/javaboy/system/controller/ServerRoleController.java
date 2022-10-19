package com.javaboy.system.controller;


import com.javaboy.common.domain.ResponseEntity;
import com.javaboy.common.enums.AppCode;
import com.javaboy.system.entity.ServerRole;
import com.javaboy.system.entity.ServerUser;
import com.javaboy.system.service.ServerRoleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-10-17 04:42:44
 */
@Tag(name = "角色模块")
@RestController
@RequestMapping("/system/serverRole")
public class ServerRoleController {

    @Resource
    private ServerRoleService serverRoleService;

    @PostMapping("/list")
    @Operation(summary = "角色管理")
    public ResponseEntity<List<ServerRole>> list() {
        List<ServerRole> serverRoleList = serverRoleService.list();
        return ResponseEntity.ok(serverRoleList);
    }

    @GetMapping("/query")
    @Operation(summary = "角色查询")
    public ResponseEntity<ServerRole> query(@RequestParam(value = "id")String id) {
        ServerRole role = serverRoleService.getById(id);
        return ResponseEntity.ok(role);
    }

    @GetMapping("/edit")
    @Operation(summary = "角色修改")
    public ResponseEntity edit(@RequestBody ServerRole serverRole) {
        boolean flag = serverRoleService.updateById(serverRole);
        if(flag){
            return ResponseEntity.ok();
        }else{
            return ResponseEntity.fail(AppCode.CHANGE_ROLE_EXCEPTION);
        }
    }

    @GetMapping("/delete")
    @Operation(summary = "角色删除")
    public ResponseEntity delete(@RequestParam(value = "id")String id) {
        boolean flag = serverRoleService.removeById(id);
        if(flag){
            return ResponseEntity.ok();
        }else{
            return ResponseEntity.fail(AppCode.DELETE_ROLE_EXCEPTION);
        }
    }

}

