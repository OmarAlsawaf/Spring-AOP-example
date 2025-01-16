package com.example.demo.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCuts {

    @Pointcut("execution(* com.example.demo.service.*.*(..))")
    public void servicePackageConfig(){}
    // now you can use this pointcut "com.example.demo.aspects.servicePackageConfig" as a refrence to the service package
    // this way if the package name / path changes you only need to change it here and the @Aspects are not affected
}
