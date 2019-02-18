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
@TableName(value = "sys_resources")
public class SysResources implements Serializable {
    @TableField(value = "RESOURCE_ID")
    private String resourceId;

    @TableField(value = "RESOURCE_NAME")
    private String resourceName;

    @TableField(value = "RESOURCE_DESC")
    private String resourceDesc;

    @TableField(value = "RESOURCE_TYPE")
    private String resourceType;

    @TableField(value = "RESOURCE_STRING")
    private String resourceString;

    @TableField(value = "PRIORITY")
    private Integer priority;

    @TableField(value = "ENABLED")
    private Integer enabled;

    @TableField(value = "ISSYS")
    private Integer issys;

    @TableField(value = "MODULE")
    private String module;

    private static final long serialVersionUID = 1L;

    public static final String COL_RESOURCE_ID = "RESOURCE_ID";

    public static final String COL_RESOURCE_NAME = "RESOURCE_NAME";

    public static final String COL_RESOURCE_DESC = "RESOURCE_DESC";

    public static final String COL_RESOURCE_TYPE = "RESOURCE_TYPE";

    public static final String COL_RESOURCE_STRING = "RESOURCE_STRING";

    public static final String COL_PRIORITY = "PRIORITY";

    public static final String COL_ENABLED = "ENABLED";

    public static final String COL_ISSYS = "ISSYS";

    public static final String COL_MODULE = "MODULE";
}