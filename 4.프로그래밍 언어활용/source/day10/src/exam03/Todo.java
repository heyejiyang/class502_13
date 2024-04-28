package exam03;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Todos.class)//class클래스가 매개변수, 반복해서 담아줄 애노테이션이 뭔지 담아줘야한다
public @interface Todo {
    //여러개를 Todos에 들어가도록
    String value(); // 이 값을 Todos에

}
