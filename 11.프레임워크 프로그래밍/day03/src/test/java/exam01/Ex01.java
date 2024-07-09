package exam01;

import org.junit.jupiter.api.Test;

import java.io.FilterOutputStream;
import java.lang.reflect.Proxy;

public class Ex01 {

    /**
     * 1.ClassLoader: 프록시 클래스가 로드될 때 사용할 클래스 로더입니다.
     * 2.Interfaces: 프록시가 구현할 인터페이스 배열입니다.
     * 3.InvocationHandler: 프록시 인스턴스의 메서드 호출을 처리할 핸들러입니다
     */
    @Test
    void test1(){
        //범용적으로 반환값은 object
        //매개변수: 1. 클래스로더, 2. Class 클래스 인터페이스, 3. InvocationHandler
        Object obj = Proxy.newProxyInstance(
          Calculator.class.getClassLoader(),
          new Class[]{Calculator.class},
          new CalculatorHandler(new RecCalculator())//생성자 매개변수에 구현체 객체(호출하고자 한 객체) 주입
        );
        //Calculator에 정의 된 invoke메서드가 호출됨

        Calculator cal = (Calculator)obj;
        long result = cal.factorial(10L);
        //바로 실행 x, invoke 메서드 거쳐서 실행됨

        System.out.println(result);

    }
}
