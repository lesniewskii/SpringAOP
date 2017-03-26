package com.lesniewski.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by adrian on 20.03.17.
 */

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());
    @Pointcut("execution(* *(..))")
    public void allMethods(){
    }


    @Before("allMethods()")
    public void logBeforeMethod(JoinPoint joinPoint){
        logger.info("Executing method" + joinPoint.getSignature().getName());
    }
    @After("execution(* *(..))")
    public void logAfterMethod(JoinPoint joinPoint){
        logger.info("Executing method" + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "allMethods()", returning = "returnedValue")
    public void logAfterReturning(Object returnedValue){
        logger.info("Returned Value: " + returnedValue);
    }

    @AfterThrowing(pointcut = "allMethods()", throwing = "exception")
    public void logAfterThrowning(JoinPoint joinPoint, Throwable exception) {

        logger.info("Method" + joinPoint.getSignature().getName() + " has thrown" + exception);
    }

    @Around("allMethods()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object methodExecutionResult =  proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.info("Excecution time: " + (end - start + "ms"));
        return methodExecutionResult;
    }
}
