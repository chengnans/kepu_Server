package com.kj.config;

import com.kj.exception.HintException;
import com.kj.permission.PermissionException;
import com.kj.vo.Result;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 破晓
 * @date 2022-01-09 17:45
 */
@RestControllerAdvice
public class ZeusExceptionHandler {

    /**
     * 处理请求失败后 提示具体原因
     */
    @ExceptionHandler(value = HintException.class)
    public Result hintExceptionHandler(HintException e) {
        return new Result().fail(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e) {
        return new Result().fail(e.getMessage());
    }

    @ExceptionHandler(value = {UnknownAccountException.class, IncorrectCredentialsException.class})
    public Result UnknownAccountException(Exception e) {
        return new Result().fail("用户名或密码错误");
    }

    @ExceptionHandler(value = PermissionException.class)
    public Result PermissionException(Exception e) {
        return new Result().insufficientPermissions(e.getMessage());
    }
}
