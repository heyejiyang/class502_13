package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class ProxyCalculator2 {

//    @Pointcut("execution(* exam01..*(..))")
//    public void publicTarget(){}

   // @Around("execution(* exam01..*(..))") //메서드 호출 전, 후 공통기능
   // @Around("config.CommonPointcut.publicTarget()")
    //같은 패키지 일때는 패키지명도 생략 가능
    @Around("CommonPointcut.publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {

        long stime = System.nanoTime();

        try {
            Object result = joinPoint.proceed();

            return result;
        }finally {
            long etime = System.nanoTime();
         //   System.out.printf("걸린시간: %d\n",etime - stime);
        }
    }
}
