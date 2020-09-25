package com.sample.project.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Slf4j
@Aspect
@Component
public class LoggingAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    @Before("execution(* com.sample.project.Service.ServiceClass.*(..))")
    public void logBeforeAllMethods(JoinPoint joinPoint) {
        log.debug("****LoggingAspect.logBeforeAllMethods() : " + joinPoint.getSignature().getName());
    }


    @Before("execution(* com.sample.project.Service.ServiceClass.saveUsers(..))")
    public void logBeforeAddEmployee(JoinPoint joinPoint) {
        log.debug("****LoggingAspect.logBeforeCreateEmployee() : " + joinPoint.getSignature().getName());
    }
}
