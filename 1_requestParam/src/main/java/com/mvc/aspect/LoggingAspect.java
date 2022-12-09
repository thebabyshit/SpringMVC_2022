package com.mvc.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
@Transactional
@Slf4j
public class LoggingAspect {

    @Pointcut("@annotation(com.mvc.anno.MyLog)")
    public void pointCut(){}

    @Around(value = "execution(* com.mvc.service.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.debug("exception-----------------before------");
        Object obj = pjp.proceed();
        log.trace("******"+pjp.getSignature());
        log.debug("exception-----------------after------");
        return obj;
    }

    @Before(value = "pointCut()")
    public void before(){
        log.info("-----------------------------------------------");
        log.info("---^^^^^^^^^^^^^Before^^^^^^^^^^^^^^^^^^^^^----");
        log.info("-----------------------------------------------");
    }
}
