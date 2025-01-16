package com.example.demo.aspects.performanceTracking;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTracker {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    //use custom defined annotations to mark the method you want to apply this aspect on
    @Around("@annotation(com.example.demo.annotations.TrackTime)")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Start time
        Long startTime = System.currentTimeMillis();

        // execute method
        Object returnVal = proceedingJoinPoint.proceed();
        //end time
        Long endTime = System.currentTimeMillis();

        //end - start
        Long executionDuration = endTime - startTime;

        logger.info(" {} method finished execution in : {} ms" ,proceedingJoinPoint,executionDuration);

        return returnVal;
    }
}
