package org.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.choongang.config.MvcConfig;
import org.choongang.exam.PostData;
import org.choongang.member.controllers.RequestJoin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@SpringJUnitWebConfig
@ContextConfiguration(classes = MvcConfig.class)
public class Ex02 {

    @Autowired
    private ObjectMapper om;

    @Test
    void test1() {
        URI url = UriComponentsBuilder.fromUriString("https://www.naver.com")
                .path("/news/{0}")
                .queryParam("t1", "v1")
                .queryParam("t2", "v2")
                .queryParam("t3", "한글")
                .queryParam("t4", "aa{1}")
                .fragment("hash")
                .encode()
                .build("AAAA", "BBBB");

        System.out.println(url);

    }

    @Test
    void test2() {
        RestTemplate restTemplate = new RestTemplate();
        PostData data = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", PostData.class);
        System.out.println(data);
    }

    @Test
    void test3() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String body = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", String.class);

        //단일 객체 변환
        PostData data = om.readValue(body, PostData.class);
        System.out.println(data);

        //복합 데이터 객체 변환 -List, Set, Map
        String itemsBody = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", String.class);
        List<PostData> items = om.readValue(itemsBody, new TypeReference<>() {});
        items.forEach(System.out::println);
    }

    @Test
    @DisplayName("POST방식")
    void test4() throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        RequestJoin form = new RequestJoin();
        //자바 객체로 넣어주고
        form.setEmail("user999@test.org");
        form.setPassword("12341234");
        form.setConfirmPassword(form.getPassword());
        form.setUserName("사용자999");
        form.setAgree(true);

        //JSON 형태로 바꿔줌

        String params = om.writeValueAsString(form);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // 반환값 MediaType - enum 상수

        HttpEntity<String> request = new HttpEntity<>(params, headers);

        String url = "http://localhost:5000/day05/api/member";
        ResponseEntity<String> response = restTemplate.postForEntity(url,request, String.class);
        System.out.println(response);
    }

    @Test
    @DisplayName("일반 양식 형식으로 전송 - Content-Type: application/x-www-form-url-urlencoded")
    void test5() {
        RestTemplate restTemplate =  new RestTemplate();

        // 요청 데이터를 키:값 형태로 담음
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("email","user999@test.org"); //put은 하나의 이름에 여러개 담을때, 단일 데이터일경우 add
        params.add("password","12341234");
        params.add("confirmPassword","12341234");
        params.add("userName","사용자998");
        params.add("agree","true"); //약관동의
        //post형태로 바디 데이터 만듦

        //헤더
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); //전송하는 데이터 형식 알려줌

        //바디데이터의 종류를 알려주기
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        String url = "http://localhost:5000/day05/member/join";

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        System.out.println(response);

    }
}
