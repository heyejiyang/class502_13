package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Order(1) //숫자가 작은 숫자부터 적용
public class ProxyCache {

    private Map<Long, Object> data = new HashMap<>();

//    @Pointcut("execution(* exam01..*(..))")
//    public void publicTarget(){
//    }

    @Around("CommonPointcut.publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        Long num = (Long)args[0];
        //캐시된 값이 있으면 그대로 쓰고 없으면 캐시 등록
        if(data.containsKey(num)){// 이미 캐시에 저장된 결과 값이 있으면 호출
            System.out.println("캐시 사용");
            return data.get(num);
        }

        Object result = joinPoint.proceed();
        data.put(num, result); //캐시에 저장
        System.out.println("캐시에 저장...");

        return result;
    }
}
