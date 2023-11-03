package com.cetus.core.orm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@TableName("cetus_system_param")
public class SystemParam implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    String id;

    @TableField(value = "group_id")
    String groupId;

    @TableField(value = "param_group_id")
    String paramGroupId;

    @TableField(value = "param_id")
    String paramId;

    @TableField(value = "param_name")
    String paramName;

    @TableField(value = "param_value")
    String paramValue;

    @TableField(value = "remark")
    String remark;

    @TableField(value = "load_mode")
    String load_mode;

    @TableField(value = "allow_modify")
    String allow_modify;

    @TableField(value = "is_enabled")
    String is_enabled;

    @TableField(value = "created")
    LocalDateTime created;

    @TableField(value = "created_by")
    String createdBy;

    @TableField(value = "updated")
    LocalDateTime updated;

    @TableField(value = "updated_by")
    String updatedBy;

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
