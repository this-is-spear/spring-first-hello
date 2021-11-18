package imaspear.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Imaspear on 2021-11-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Aspect
public class TimeTraceAop {
//    패키지에 모두 적용
    @Around("execution(* imaspear.hellospring..*(..)) && !target(imaspear.hellospring.SpringConfig)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
        }
    }
}
