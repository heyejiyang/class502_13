package exam02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorHandler implements InvocationHandler {//InvocationHandler 인터페이스를 구현하여 프록시 객체에서 호출되는 메서드를 처리

    private Object obj; //실제로 메서드를 수행할 대상 객체

    public CalculatorHandler(Object obj){ //프록시 객체가 대리할 실제 객체를 인자로 받아서 초기화함
        this.obj = obj;
    }

    /**
     *
     * @param proxy the proxy instance that the method was invoked on
     *
     * @param method : 호출한 메서드의 정보, 동적 메서드 호출 method.invoke(...)
     *
     * @param args: 메서드 호출시 넘겨준 값(인수)
     *
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { //프록시 객체의 메서드가 호출 될 때 실행되는 메서드
        /*
        * proxy: 메서드가 호출된 프록시 객체입니다.
          method: 호출된 메서드의 정보를 담고 있는 Method 객체입니다.
          args: 메서드 호출 시 전달된 인수입니다.
        * */

        System.out.println(proxy.getClass()); //실제 만들어진 객체
        // 실제로 생성된 프록시 객체의 클래스 정보를 출력

        long stime = System.nanoTime(); //공통기능 ,메서드 실행 전 현재 시간을 나노초 단위로 기록
        try{
            Object result = method.invoke(obj, args); //핵심 기능 - proxy가 대신 수행
            //실제 객체의 메서드를 호출

            return result;
        }finally {
            long etime = System.nanoTime(); //공통기능
            //메서드 실행 후의 시간을 기록하고, 실행 시간을 출력

            System.out.println("걸린시간:"+ (etime - stime));
        }
    }
}
