package com.kj.enums;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 破晓
 * @date 2022-01-09 17:17
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ResultCode {

    OK(200, true, "ok"),
    FAIL(500, false, "fail"),
    NOTFOUND(404, false, "not found"),
    PERMISSION(401, false, "insufficient permissions");

    private Integer code;

    private Boolean success;

    private String msg;
}
