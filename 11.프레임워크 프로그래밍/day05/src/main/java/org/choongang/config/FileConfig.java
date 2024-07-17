package org.choongang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer{

    @Value("${file.upload.path}") //application.properties에 정의한 키값
    private String uploadPath; //명칭으로 설정값 주입

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //파일 업로드 정적 경로 설정
        registry.addResourceHandler("/uploads/**")
//                .addResourceLocations("file:///D:/uploads/");
                //실제 파일쪽 경로를 넣어줘야함, 파일쪽 경로 입력할때는 / 하나 제거되기 때문에 3개 넣어야함
                 .addResourceLocations("file:///" + uploadPath);
    }
}
