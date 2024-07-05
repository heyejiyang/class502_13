package exam01.config;

import exam01.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//설정 클래스 - 스프링 컨테이너가 관리할 객체를 정의하고 설정하는 역할
@Configuration
public class AppCtx {

    @Bean //스프링 컨테이너가 관리 해야할 객체임을 알려주는 역할(Bean)
    public Greeter greeter(){
        return new Greeter();
    }
}
