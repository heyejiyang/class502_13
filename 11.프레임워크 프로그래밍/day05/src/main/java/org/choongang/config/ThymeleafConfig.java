package org.choongang.config;


import lombok.RequiredArgsConstructor;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@RequiredArgsConstructor
public class ThymeleafConfig  implements WebMvcConfigurer {
    private final WebApplicationContext applicationContext;
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates2/");
        templateResolver.setSuffix(".html"); //네츄럴 템플릿
        templateResolver.setCacheable(false); //캐시 - 배포시 true로 바꿈
        //요청시마다 번역을 해야지 작업물을 볼 수 있기 때문에 false로 해둬야함
        // 번역? 서버가 일을 한다
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true); //true -> el식 지원
        templateEngine.addDialect(new Java8TimeDialect()); //addDialect 확장 기능 설정
        templateEngine.addDialect(new LayoutDialect());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        //템플릿쪽에 반복적으로 설정 해줘야했던 부분 여기서 추가함
        resolver.setContentType("text/html");
        resolver.setCharacterEncoding("utf-8");
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(thymeleafViewResolver());
    }

}
