package org.choongang.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("org.choongang") //스캔 범위 설정, 해당 경로에서 스프링 빈 검색
/*
@Import({DBConfig.class,MessageConfig.class,
        InterceptorConfig.class, FileConfig.class})
@RequiredArgsConstructor  */
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

    //타임리프 때문에 주석처리함
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp("/WEB-INF/templates/", ".jsp");
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("main/index");

        registry.addViewController("/mypage")
                .setViewName("mypage/index");
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {

        String fileName = "application";
        String profile = System.getenv("spring.profiles.active");
        fileName += StringUtils.hasText(profile) ? "-" + profile : "";

        /**
         * spring.profiles.active=dev
         * -> application-dev
         *
         * spring.profiles.active=prod
         * -> application-prod
         */

        //PropertySources: 프로퍼티 파일에 있는 내용 , PlaceholderConfigurer: 설정 방법
        PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();

        conf.setLocations(new ClassPathResource(fileName+".properties")); //리소스 폴더에 접근할때 -  ClassPathResource

        return conf;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder
                .json()
                .serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(formatter))
                .build();

        converters.add(0,new MappingJackson2HttpMessageConverter(objectMapper));
    }
}
