package com.kj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kj.enums.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 破晓
 * @date 2022-01-23 16:22
 *
 * 管理员信息表
 */
@TableName("admin_information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformation {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色
     */
    private AdminRole role;

    private Date createTime;

    private Date updateTime;
}