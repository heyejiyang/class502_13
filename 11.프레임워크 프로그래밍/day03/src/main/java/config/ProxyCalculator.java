package config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect //공통 기능이 적용될 클래스임을 나타냄
public class ProxyCalculator {

    @Pointcut("execution(* exam01..*(..))") //exam01에 모든 클래스, 메서드
    //공통 기능이 적용될 패키지 범위를 설정, 메서드 패턴 설정
    public void publicTarget(){}

    @Before("publicTarget()") // 메서드가 호출 되기 전 공통 기능 정의
    public void before(JoinPoint joinPoint){
        System.out.println("Before..");
    }

    @After("publicTarget()") //메서드가 호출 된 후 공통 기능 정의
    public void after(JoinPoint joinPoint){
        System.out.println("After..");
    }

    @AfterReturning( value ="publicTarget()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint,Object returnValue) throws Throwable{
        System.out.println("AfterReturning:"+returnValue);
    }

    @AfterThrowing(value = "publicTarget()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Throwable e) throws Throwable{
        System.out.println("afterThrowing");
        e.printStackTrace();

    }

    @Around("publicTarget()") //메서드 호출 전, 호출 후 공통 기능을 정의
    //publicTarget()으로 실행 범위를 찾는다
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {

//        Signature sig = joinPoint.getSignature(); //호출된 메서드 정의에 대한 정보
//        System.out.println(sig.toLongString());
//
//        Object[] args = joinPoint.getArgs();//투입된 인수 - 매개변수에 대한 정보
//        System.out.println(Arrays.toString(args));
//
//        Object obj = joinPoint.getTarget(); //호출한 메서드를 가지고 있는 객체
//        System.out.println(obj.getClass());


        long stime = System.nanoTime(); //공통기능
        try{
            Object result = joinPoint.proceed(); //핵심 기능 대신 실행 - factorial

            boolean re = false;
            if(!re){
                throw new RuntimeException("예외 테스트...");
            }

            return result;
        }finally {
            long etime = System.nanoTime(); //공통기능
            System.out.println("걸린시간: "+(etime-stime));
        }

    }
}
