package com.kj.vo.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 破晓
 * @date 2022-01-23 18:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformationAddVO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
