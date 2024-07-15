package org.choongang.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageConfig {
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setBasenames("messages.commons","messages.validations","messages.errors"); //classpath 기준
        ms.setDefaultEncoding("UTF-8");
        ms.setUseCodeAsDefaultMessage(true); //코드 없을때는 코드 그 자체로 출력될 수 있도록 함
        return ms;
    }
}
