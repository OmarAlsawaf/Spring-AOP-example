package com.example.demo.aspects.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//mark this as a AOP configuration class
@Configuration
@Aspect
public class LoggerComponent {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //pointcut : is to define when to call this method
    // syntax : execution (* PACKAGE.*.*(..))
    @Before("execution(* com.example.demo.*.*.*(..))")
    public void logMethodStart(JoinPoint joinPoint){
        //behaviour : what to do when called
        logger.info("starting method : {}" , joinPoint);

    }

    @After("execution(* com.example.demo.*.*.*(..))")
    public void logMethodEnd(JoinPoint joinPoint){
        //behaviour : what to do when called
        logger.info("ending method : {}" , joinPoint);

    }

    @AfterThrowing(pointcut = "execution(* com.example.demo.*.*.*(..))",
    throwing = "ex")
    public void logMethodException(JoinPoint joinPoint,Exception ex){
        //behaviour : what to do when called
        logger.info("exception in method : {} , exception : {}" ,
                joinPoint,
                ex.toString());
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.*.*.*(..))",
                    returning = "result")
    public void logMethodReturn(JoinPoint joinPoint,Object result){
        //behaviour : what to do when called
        logger.info("return of method : {} , result is : {}" ,
                joinPoint,
                result);
    }
}
