package com.githup.ussheepsheep.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by daren on 2017/2/10.
 */
@Aspect
@Component
public class WebLogAspect {

    private Logger logger = LogManager.getLogger(getClass());

    @Pointcut("execution(public * com.githup.ussheepsheep.web..*.*(..))")
    public void weblog() {
    }

    @Around("weblog()")
    public Object around(ProceedingJoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Long start = System.currentTimeMillis();
        logger.info("{} enter {}.{} with args = {}", request.getRemoteAddr(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        try {
            Object obj = joinPoint.proceed();
            Long time = System.currentTimeMillis() - start;
            logger.info("{} exit {}.{} used {} ms with result : {}", request.getRemoteAddr(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), time, obj);
            return obj;
        } catch (Throwable throwable) {
            logger.error("{} reqs error : {}.{} args = {}", request.getRemoteAddr(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
            throwable.printStackTrace();
        }
        return null;
    }
}
