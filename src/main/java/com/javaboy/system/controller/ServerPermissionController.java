package com.javaboy.system.controller;


import com.javaboy.common.domain.ResponseEntity;
import com.javaboy.common.enums.AppCode;
import com.javaboy.system.entity.ServerPermission;
import com.javaboy.system.entity.ServerRole;
import com.javaboy.system.service.ServerPermissionService;
import com.javaboy.system.service.ServerRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-10-17 04:42:44
 */
@Tag(name = "权限模块")
@RestController
@RequestMapping("/system/serverPermission")
public class ServerPermissionController {

    @Resource
    private ServerPermissionService serverPermissionService;

    @PostMapping("/list")
    @Operation(summary = "权限管理")
    public ResponseEntity<List<ServerPermission>> list() {
        List<ServerPermission> serverPermissionList = serverPermissionService.list();
        return ResponseEntity.ok(serverPermissionList);
    }

    @GetMapping("/query")
    @Operation(summary = "权限查询")
    public ResponseEntity<ServerPermission> query(@RequestParam(value = "id")String id) {
        ServerPermission permission = serverPermissionService.getById(id);
        return ResponseEntity.ok(permission);
    }

    @GetMapping("/edit")
    @Operation(summary = "权限修改")
    public ResponseEntity edit(@RequestBody ServerPermission serverPermission) {
        boolean flag = serverPermissionService.updateById(serverPermission);
        if(flag){
            return ResponseEntity.ok();
        }else{
            return ResponseEntity.fail(AppCode.CHANGE_PERMISSION_EXCEPTION);
        }
    }

    @GetMapping("/delete")
    @Operation(summary = "权限删除")
    public ResponseEntity delete(@RequestParam(value = "id")String id) {
        boolean flag = serverPermissionService.removeById(id);
        if(flag){
            return ResponseEntity.ok();
        }else{
            return ResponseEntity.fail(AppCode.DELETE_PERMISSION_EXCEPTION);
        }
    }
}

