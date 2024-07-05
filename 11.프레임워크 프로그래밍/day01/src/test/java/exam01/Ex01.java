package exam01;

import exam01.config.AppCtx;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    @Test
    void test1(){
        //스프링 컨테이너 객체 생성
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        //위 컨테이너 안에 현재 Greeter객체가 담겨있다.

        Greeter greet = ctx.getBean("greeter", Greeter.class);
        greet.hello("성준");
        System.out.println(greet);

        Greeter greet2 = ctx.getBean("greeter", Greeter.class);
        greet2.hello("뿡");
        System.out.println(greet2); //주소 같음

        System.out.println(greet == greet2); //true


        ctx.close();
    }

    @Test
    void test2(){
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

       Greeter g1 = ctx.getBean(Greeter.class);
       //싱글톤이기 때문에(해당 객체는 1개) 이렇게 찾는것도 가능함

        g1.hello("짱쭌");

        ctx.close();
    }
}
