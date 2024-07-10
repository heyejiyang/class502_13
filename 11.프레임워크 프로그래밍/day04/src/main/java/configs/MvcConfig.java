package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("member")
@Import(DBConfig.class) //설정이 추가되면 import로
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //기본 경로(메인 경로) 들어 왔을때 처리 부분 세팅
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //ViewResolver -> 출력할 템플릿을 찾아줌

        registry.jsp("/WEB-INF/templates/", ".jsp"); //prefix, suffix 경로를 합쳐서 view 경로를 찾는다. registry반환값이 prefix와 suffix사이에 들어온다.
    }
}