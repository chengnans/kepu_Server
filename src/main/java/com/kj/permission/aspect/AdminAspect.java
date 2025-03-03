package com.kj.permission.aspect;

import com.kj.dto.Principal;
import com.kj.enums.ResultCode;
import com.kj.permission.PermissionException;
import com.kj.permission.annotation.Permission;
import com.kj.util.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author 破晓
 * @date 2022-01-23 22:32
 */
@Component
@Aspect
@Slf4j
public class AdminAspect {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping) || @annotation(org.springframework.web.bind.annotation.PostMapping) || @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void mappingPoint() {
    }

    @Pointcut("@annotation(com.kj.permission.annotation.GeneralAdmin) || @annotation(com.kj.permission.annotation.SuperAdmin)")
    private void permissionPoint() {}

    private static final String ATTRIBUTE_NAME = "role";

    @Before("permissionPoint() && mappingPoint()")
    public void before(@NonNull JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            log.info("仅支持方法级权限校验");
            return;
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        // Spring 注解属性的隐式替换
        AnnotationAttributes mergedAnnotationAttributes = AnnotatedElementUtils.findMergedAnnotationAttributes(method, Permission.class, false, true);

        if(Objects.nonNull(mergedAnnotationAttributes)) {
            Integer role = (Integer) mergedAnnotationAttributes.get(ATTRIBUTE_NAME);
            Principal principal = ShiroUtils.getPrincipal();
            log.info("{}访问：{}", principal, role);
            if(Objects.nonNull(principal) && principal.getRole().getKey() >= role) {
                return;
            }
        }

        throw new PermissionException();
    }
}
