package com.cetus.orm.entity;

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
public class CetusUserInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    String id;

    @TableField(value = "uid")
    String uid;

    @TableField(value = "uname")
    String uname;

    @TableField(value = "password")
    String password;

    @TableField(value = "email")
    String email;

    @TableField(value = "login_ip")
    String loginIp;

    @TableField(value = "status")
    String status;

    @TableField(value = "is_locked")
    String isLocked;

    @TableField(value = "lock_reason")
    String lockReason;

    @TableField(value = "last_access_time")
    LocalDateTime lastAccessTime;

    @TableField(value = "last_logout_time")
    LocalDateTime lastLogoutTime;

    @TableField(value = "last_failed_time")
    LocalDateTime lastFailedTime;

    @TableField(value = "failed_count")
    Integer failedCount;

    @TableField(value = "total_failed_count")
    Integer totalFailedCount;

    @TableField(value = "last_pwd_chg_time")
    String lastPwdChgTime;

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

    @TableField(value = "remarks")
    String remarks;
}
