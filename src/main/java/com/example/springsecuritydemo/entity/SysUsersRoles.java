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
@TableName(value = "sys_users_roles")
public class SysUsersRoles implements Serializable {
    @TableField(value = "ID")
    private Integer id;

    @TableField(value = "USER_ID")
    private String userId;

    @TableField(value = "ROLE_ID")
    private String roleId;

    @TableField(value = "ENABLED")
    private Integer enabled;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "ID";

    public static final String COL_USER_ID = "USER_ID";

    public static final String COL_ROLE_ID = "ROLE_ID";

    public static final String COL_ENABLED = "ENABLED";
}