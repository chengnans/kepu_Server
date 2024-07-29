package com.kj.dto;

import com.kj.enums.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 破晓
 * @date 2022-01-24 0:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Principal {

    /**
     * 用户名
     */
    private String username;

    /**
     * 角色
     */
    private AdminRole role;
}
