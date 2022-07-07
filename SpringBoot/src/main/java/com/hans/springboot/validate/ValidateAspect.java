package com.hans.springboot.validate;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.validation.Validator;
import java.util.Set;

/**
 * 校验参数切面类
 * 2019/10/13 17:26
 *
 * @author konglinghan
 * @version 1.0
 */
@Component
@Aspect
@Order(2)
public class ValidateAspect {

    @Resource
    Validator validator;

    @Around("@annotation(com.haodf.service.usertask.annotation.ValidateBody)")
    public Object validateParam(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            Set<ConstraintViolation<Object>> inValid = validator.validate(arg);
            if (!inValid.isEmpty()) {
                StringBuilder msg = new StringBuilder();
                for (ConstraintViolation<Object> objectConstraintViolation : inValid) {
                    String message = objectConstraintViolation.getMessage();
                    Path propertyPath = objectConstraintViolation.getPropertyPath();
                    msg.append(propertyPath).append(message).append(";");
                }
                return RpcResponse.error(new ErrorInfo(1001, msg.toString()));
            }
        }
        return joinPoint.proceed(args);
    }

    @Around("@annotation(com.haodf.service.usertask.annotation.ValidateParam)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (ConstraintViolationException e) {
            throw new RpcBizException(new ErrorInfo(1001, e.getLocalizedMessage()));
        }
    }

    @Around("@annotation(com.haodf.service.usertask.annotation.SpringAssert)")
    public Object assertAround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (IllegalArgumentException e) {
            throw new RpcBizException(new ErrorInfo(1001, e.getLocalizedMessage()));
        }
    }
}
