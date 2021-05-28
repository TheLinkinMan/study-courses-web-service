package com.study.courses.webservice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;

@Slf4j
public aspect LoggingAspect {

    @Around("execution(* com.study.courses.webservice.service.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint point) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        String methodName = methodSignature.getName();

        log.info("Begin of " + methodName);

        Object targetMethodResult = point.proceed();

        log.info("End of " + methodName);

        return targetMethodResult;
    }
}
