package org.choongang.config;

import lombok.RequiredArgsConstructor;
import org.choongang.global.interceptors.MemberOnlyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private final MemberOnlyInterceptor memberOnlyInterceptor; //마이페이지

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(memberOnlyInterceptor)
                .addPathPatterns("/mypage/**");/*패턴 추가해서 여러 페이지 추가할 수 있다*//* 별표 두개 -> 현재 경로 포함 하위 경로*/
    }
}
