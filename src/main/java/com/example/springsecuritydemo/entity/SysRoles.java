package com.example.springsecuritydemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
* Created by Mybatis Generator 2019/01/18
*/
@Data
@TableName(value = "sys_roles")
public class SysRoles implements Serializable {
    @TableField(value = "ROLE_ID")
    private String roleId;

    @TableField(value = "ROLE_NAME")
    private String roleName;

    @TableField(value = "ROLE_DESC")
    private String roleDesc;

    @TableField(value = "ENABLED")
    private Integer enabled;

    @TableField(value = "ISSYS")
    private Integer issys;

    @TableField(value = "MODULE")
    private String module;

    private static final long serialVersionUID = 1L;

    public static final String COL_ROLE_ID = "ROLE_ID";

    public static final String COL_ROLE_NAME = "ROLE_NAME";

    public static final String COL_ROLE_DESC = "ROLE_DESC";

    public static final String COL_ENABLED = "ENABLED";

    public static final String COL_ISSYS = "ISSYS";

    public static final String COL_MODULE = "MODULE";
}