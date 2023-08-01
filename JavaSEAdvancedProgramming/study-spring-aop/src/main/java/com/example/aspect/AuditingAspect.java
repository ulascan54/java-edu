package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class AuditingAspect {
    @Around("execution(* com.example..*(..))")
    public Object profile(ProceedingJoinPoint pjp ) throws  Throwable{
        System.out.println("%s is called at %s".formatted(pjp.getSignature().getName(),new Date()));
        var result = pjp.proceed();
        System.out.println("%s is called at %s".formatted(pjp.getSignature().getName(),result));
        return result;
    }
}
