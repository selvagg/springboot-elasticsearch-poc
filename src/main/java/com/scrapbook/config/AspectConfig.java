package com.scrapbook.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*@AfterReturning(pointcut = "execution(* com.scrapbook.controller*(..))")
    public void logServiceAccess(JoinPoint joinPoint, Object result) {
        logger.info("Completed: {}", joinPoint);
    }*/


    @Around("@annotation(com.scrapbook.annotations.TrackTime)")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
    }


}