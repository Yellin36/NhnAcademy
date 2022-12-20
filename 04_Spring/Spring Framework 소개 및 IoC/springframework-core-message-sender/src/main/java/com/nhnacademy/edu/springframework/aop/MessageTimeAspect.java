package com.nhnacademy.edu.springframework.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MessageTimeAspect {
    @Around("execution(* com.nhnacademy.edu.springframework.messagesender..sendMessage(..))")
    public Object timeChecking(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();

            Object retVal = pjp.proceed();

            return retVal;
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }

    }
}
