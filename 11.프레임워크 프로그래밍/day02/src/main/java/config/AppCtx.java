package config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //설정클래스임을 알려주는 애노테이션
@ComponentScan("member") //자동 스캔 - 지정한 패키지 범위를 기본 스캔 대상으로 스캔 -> 스캔 대상 애노테이션을 찾는다.
public class AppCtx {


}
