package exam01;

import exam02.Calculator;
import exam02.CalculatorHandler;
import exam02.RecCalculator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class Ex02 {

    @Test
    void test1(){
        Object obj = Proxy.newProxyInstance(
          Calculator.class.getClassLoader(),new Class[]{Calculator.class},new CalculatorHandler(new RecCalculator())
        );

        Calculator cal = (Calculator)obj;
        long result =cal.factorial(10L);
        System.out.println(result);

        System.out.println(cal);
    }
}
/*
Object obj = Proxy.newProxyInstance(...): 동적 프록시 객체를 생성합니다.
Calculator.class.getClassLoader(): 프록시 클래스 로더를 지정합니다.
new Class[]{Calculator.class}: 프록시가 구현할 인터페이스 목록을 지정합니다.
new CalculatorHandler(new RecCalculator()): 프록시 호출 시 사용할 핸들러를 지정합니다.
Calculator cal = (Calculator)obj: 생성된 프록시 객체를 Calculator 인터페이스 타입으로 캐스팅합니다.
long result = cal.factorial(10L): 프록시 객체의 factorial 메서드를 호출합니다.
System.out.println(result): 메서드 결과를 출력합니다.
System.out.println(cal): 프록시 객체의 정보를 출력합니다.

 */

/*
test1 메서드에서 Proxy.newProxyInstance를 통해 Calculator 인터페이스를 구현하는 동적 프록시 객체를 생성합니다. 이 때, RecCalculator 객체를 실제 메서드 호출을 처리할 객체로 지정합니다.
프록시 객체의 메서드를 호출하면, CalculatorHandler의 invoke 메서드가 실행됩니다.
invoke 메서드에서 실행 시간을 측정하고, 실제 RecCalculator 객체의 메서드를 호출하여 결과를 반환합니다.
메서드 실행 시간이 측정되고, 출력됩니다.

 */