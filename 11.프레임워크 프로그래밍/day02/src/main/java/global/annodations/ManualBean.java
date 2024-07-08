package global.annodations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //target은 인터페이스나 클래스 명 위에 정의
@Retention(RetentionPolicy.RUNTIME)
public @interface ManualBean {

}
