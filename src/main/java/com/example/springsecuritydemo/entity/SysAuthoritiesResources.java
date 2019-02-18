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
@TableName(value = "sys_authorities_resources")
public class SysAuthoritiesResources implements Serializable {
    @TableField(value = "ID")
    private Integer id;

    @TableField(value = "AUTHORITY_ID")
    private String authorityId;

    @TableField(value = "RESOURCE_ID")
    private String resourceId;

    @TableField(value = "ENABLED")
    private Integer enabled;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "ID";

    public static final String COL_AUTHORITY_ID = "AUTHORITY_ID";

    public static final String COL_RESOURCE_ID = "RESOURCE_ID";

    public static final String COL_ENABLED = "ENABLED";
}