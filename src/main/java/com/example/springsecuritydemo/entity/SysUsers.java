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
@TableName(value = "sys_users")
public class SysUsers implements Serializable {
    @TableField(value = "USER_ID")
    private String userId;

    @TableField(value = "USER_ACCOUNT")
    private String userAccount;

    @TableField(value = "USER_NAME")
    private String userName;

    @TableField(value = "USER_PASSWORD")
    private String userPassword;

    @TableField(value = "USER_DESC")
    private String userDesc;

    @TableField(value = "ENABLED")
    private Integer enabled;

    @TableField(value = "ISSYS")
    private Integer issys;

    @TableField(value = "USER_DEPT")
    private String userDept;

    @TableField(value = "USER_DUTY")
    private String userDuty;

    @TableField(value = "SUB_SYSTEM")
    private String subSystem;

    private static final long serialVersionUID = 1L;

    public static final String COL_USER_ID = "USER_ID";

    public static final String COL_USER_ACCOUNT = "USER_ACCOUNT";

    public static final String COL_USER_NAME = "USER_NAME";

    public static final String COL_USER_PASSWORD = "USER_PASSWORD";

    public static final String COL_USER_DESC = "USER_DESC";

    public static final String COL_ENABLED = "ENABLED";

    public static final String COL_ISSYS = "ISSYS";

    public static final String COL_USER_DEPT = "USER_DEPT";

    public static final String COL_USER_DUTY = "USER_DUTY";

    public static final String COL_SUB_SYSTEM = "SUB_SYSTEM";
}