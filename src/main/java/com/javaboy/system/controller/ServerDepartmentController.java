package com.javaboy.system.controller;


import com.javaboy.common.domain.ResponseEntity;
import com.javaboy.common.enums.AppCode;
import com.javaboy.system.entity.ServerDepartment;
import com.javaboy.system.entity.ServerRole;
import com.javaboy.system.service.ServerDepartmentService;
import com.javaboy.system.service.ServerRoleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-10-17 04:42:43
 */
@RestController
@RequestMapping("/system/serverDepartment")
public class ServerDepartmentController {

    @Resource
    private ServerDepartmentService serverDepartmentService;

    @PostMapping("/list")
    @Operation(summary = "部门管理")
    public ResponseEntity<List<ServerDepartment>> list() {
        List<ServerDepartment> serverDepartmentList = serverDepartmentService.list();
        return ResponseEntity.ok(serverDepartmentList);
    }

    @GetMapping("/query")
    @Operation(summary = "部门查询")
    public ResponseEntity<ServerDepartment> query(@RequestParam(value = "id")String id) {
        ServerDepartment department = serverDepartmentService.getById(id);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/edit")
    @Operation(summary = "部门修改")
    public ResponseEntity edit(@RequestBody ServerDepartment serverDepartment) {
        boolean flag = serverDepartmentService.updateById(serverDepartment);
        if(flag){
            return ResponseEntity.ok();
        }else{
            return ResponseEntity.fail(AppCode.CHANGE_DEPARTMENT_EXCEPTION);
        }
    }

    @GetMapping("/delete")
    @Operation(summary = "部门删除")
    public ResponseEntity delete(@RequestParam(value = "id")String id) {
        boolean flag = serverDepartmentService.removeById(id);
        if(flag){
            return ResponseEntity.ok();
        }else{
            return ResponseEntity.fail(AppCode.DELETE_DEPARTMENT_EXCEPTION);
        }
    }
}

