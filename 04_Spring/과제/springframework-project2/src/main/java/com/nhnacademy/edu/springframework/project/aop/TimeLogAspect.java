package com.nhnacademy.edu.springframework.project.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class TimeLogAspect {
    String logFile = "src/main/resources/log/elapse.log";
    SimpleDateFormat dateFormat = new SimpleDateFormat("[ yyyy-MM-dd HH:mm:ss ]");

    @Around("execution(* com.nhnacademy.edu.springframework.project..*(..))")
    public Object timeCheckLogging(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            Object retVal = pjp.proceed();
            return retVal;
        } finally {
            stopWatch.stop();
            MethodSignature signature = MethodSignature.class.cast(pjp.getSignature());

            String className = signature.getMethod().getDeclaringClass().getSimpleName();
            String methodName = signature.getMethod().getName();
            long totalTime = stopWatch.getTotalTimeMillis();

            String time = dateFormat.format(new Date());
            String log = "\t[" + className + "].[" + methodName + "] [" + totalTime + "]ms\n";
            //log파일에 저장
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))){
                writer.write(time + log);
            }
        }
    }
}
