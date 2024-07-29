package com.kj.util;

import com.kj.dto.Principal;
import org.apache.shiro.SecurityUtils;

/**
 * @author 破晓
 * @date 2022-01-24 0:42
 */
public class ShiroUtils {

    public static Principal getPrincipal() {
        return (Principal) SecurityUtils.getSubject().getPrincipal();
    }
}
