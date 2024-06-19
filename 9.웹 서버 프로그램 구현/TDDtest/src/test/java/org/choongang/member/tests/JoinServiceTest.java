package org.choongang.member.tests;


import com.github.javafaker.Faker;
import org.choongang.global.configs.DBConn;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.services.JoinService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
@DisplayName("회원가입 기능 테스트")
public class JoinServiceTest {

    private JoinService joinService;

    @BeforeEach
    void init(){
        joinService = new JoinService();
    }

    RequestJoin getData(){
        Faker faker = new Faker(Locale.ENGLISH);
        RequestJoin form = RequestJoin
                .builder()
                .email(System.currentTimeMillis() + faker.internet().emailAddress())
                .password(faker.regexify("\\w{8}").toLowerCase())
                .userName(faker.name().fullName())
                .termsAgree(true)
                .build();
        form.setConfirmPassword(form.getPassword());
        return form;
    }




    @Test
    @DisplayName("회원가입 성공시 예외가 발생하지 않음")
    void successTest(){
        assertDoesNotThrow(()->{
            JoinService joinService = new JoinService();
            joinService.process(getData());
        });
    }
}
