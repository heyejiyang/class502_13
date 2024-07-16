package org.choongang.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan("org.choongang") //스캔 범위 설정, 해당 경로에서 스프링 빈 검색
@Import({DBConfig.class,MessageConfig.class, InterceptorConfig.class})
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

//    private final JoinValidator joinValidator;
//
//    //모든 컨트롤러에 적용 될 수 있는 공통 validator 등록
//    @Override
//    public Validator getValidator() {
//        return joinValidator;
//    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override //정적 경로 설정
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/"); //현재 경로 포함 하위 모든 경로
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("main/index");

        registry.addViewController("/mypage")
                .setViewName("mypage/index");
    }
}
