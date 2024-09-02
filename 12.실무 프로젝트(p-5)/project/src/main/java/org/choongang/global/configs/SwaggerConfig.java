package org.choongang.global.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 설정 클래스
 */
@OpenAPIDefinition(info=@Info(title = "API 명세", description = "상세 설명..", contact = @Contact(name = "yeji, Yang", email = "xoxo99312@naver.com"), version = "v1")) //문서에 관한 설명, 문서 상단에 이 정보가 들어가게 된다.
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi apiGroup(){
        return GroupedOpenApi.builder()
                .group("API 명세 v1")
                .pathsToMatch("/api/v1/**")
                .build();
    }
}
