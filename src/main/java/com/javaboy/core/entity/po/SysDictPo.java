package com.javaboy.core.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * 系统字典
 * </p>
 *
 * @author 沈金勇 438217638@qq.com
 * @since 2022-09-14 03:22:22
 */
@Getter
@Setter
@TableName("sys_dict")
@ApiModel(value = "SysDictPo对象", description = "系统字典")
public class SysDictPo {

    @ApiModelProperty("主键")
    @TableField("id")
    private String id;

    @ApiModelProperty("字典关联表")
    @TableField("table_name")
    private String tableName;

    @ApiModelProperty("字典key")
    @TableField("table_key")
    private String tableKey;

    @ApiModelProperty("字典value")
    @TableField("table_value")
    private String tableValue;

    @ApiModelProperty("创建时间")
      @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty("更新时间")
      @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @ApiModelProperty("版本号")
    @TableField("version")
    @Version
    private Integer version;

    @ApiModelProperty("逻辑删除")
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty("是否可编辑")
    @TableField("editable")
    private Integer editable;


}
