package com.kj.vo.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 破晓
 * @date 2022-01-23 16:22
 *
 * 管理员修改密码
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformationUpdateVO {

    private String username;

    /**
     * 原来的密码
     */
    private String oldPassword;

    /**
     * 新密码
     */
    private String Password;
}
