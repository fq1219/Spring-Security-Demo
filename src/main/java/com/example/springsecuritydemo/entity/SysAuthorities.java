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
@TableName(value = "sys_authorities")
public class SysAuthorities implements Serializable {
    @TableField(value = "AUTHORITY_ID")
    private String authorityId;

    @TableField(value = "AUTHORITY_NAME")
    private String authorityName;

    @TableField(value = "AUTHORITY_DESC")
    private String authorityDesc;

    @TableField(value = "ENABLED")
    private Integer enabled;

    @TableField(value = "ISSYS")
    private Integer issys;

    @TableField(value = "MODULE")
    private String module;

    private static final long serialVersionUID = 1L;

    public static final String COL_AUTHORITY_ID = "AUTHORITY_ID";

    public static final String COL_AUTHORITY_NAME = "AUTHORITY_NAME";

    public static final String COL_AUTHORITY_DESC = "AUTHORITY_DESC";

    public static final String COL_ENABLED = "ENABLED";

    public static final String COL_ISSYS = "ISSYS";

    public static final String COL_MODULE = "MODULE";
}