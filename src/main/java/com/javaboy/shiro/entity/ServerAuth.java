package com.javaboy.shiro.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-09-27 09:47:10
 */
@Getter
@Setter
@TableName("server_auth")
@ApiModel(value = "ServerAuth对象", description = "权限表")
public class ServerAuth {

    @ApiModelProperty("主键")
      @TableId("id")
    private String id;

    @ApiModelProperty("修改时间")
      @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @ApiModelProperty("创建时间")
      @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty("逻辑删除")
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty("版本号")
    @TableField("version")
    @Version
    private Integer version;

    @ApiModelProperty("权限名称")
    @TableField("permissions")
    private String permissions;

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("电话号码")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("头像")
    @TableField("avatar_url")
    private String avatarUrl;


}
