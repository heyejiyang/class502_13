package exam01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorHandler implements InvocationHandler {

    private Object obj;

    public CalculatorHandler(Object obj) {
        this.obj = obj;
    }

    //RecCalculator 구현체 수행을 대신 수행해줌
    //invoke메서드로 유입유입!
    //factorial호출할때마다 이 메서드로 유입됨
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       //method에 동적 호출 가능

        long stime = System.nanoTime(); //추가 기능  - 공통 기능, 공통 관심사

        try{

            Object result = method.invoke(obj, args); //Calculator에 있는 factorial 메서드 호출 (핵심기능 대신 수행)

            return result;

        }finally {
            long etime = System.nanoTime(); //추가 기능  - 공통 기능, 공통 관심사
            System.out.println("걸린시간: "+ (etime - stime));
        }

    }
}
