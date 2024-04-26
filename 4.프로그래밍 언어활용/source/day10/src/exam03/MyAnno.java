package exam03;

import static java.lang.annotation.ElementType.*;
//import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({TYPE, METHOD,FIELD})//설정항목이 배열형태로 되어있는 경우 -> 다중설정을 할수있다.
@Retention(RetentionPolicy.RUNTIME) //value 생략가능
public @interface MyAnno {
    int min(); //추상메서드 min()설정 항목
    int max();//max()설정 항목

}
