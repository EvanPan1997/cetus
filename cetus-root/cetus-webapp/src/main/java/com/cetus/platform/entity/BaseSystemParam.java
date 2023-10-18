package com.cetus.platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("CETUS_SYSTEM_PARAM")
public class BaseSystemParam {

    @TableId(value = "id", type = IdType.AUTO)
    String id;

    @TableField(value = "group_id")
    String groupId;

    @TableField(value = "sub_group_id")
    String subGroupId;

    @TableField(value = "param_group_id")
    String paramGroupId;

    @TableField(value = "param_no")
    String paramNo;

    @TableField(value = "param_name")
    String paramName;

    @TableField(value = "param_value")
    String paramValue;

    @TableField(value = "remark")
    String remark;

    @TableField(value = "created")
    LocalDateTime created;

    @TableField(value = "created_by")
    String createdBy;

    @TableField(value = "changed")
    LocalDateTime changed;

    @TableField(value = "changed_by")
    String changedBy;

    @TableField(value = "rsv1")
    String rsv1;

    @TableField(value = "rsv2")
    String rsv2;

    @TableField(value = "rsv3")
    String rsv3;

    @TableField(value = "rsv4")
    String rsv4;

    @TableField(value = "rsv5")
    String rsv5;
}
