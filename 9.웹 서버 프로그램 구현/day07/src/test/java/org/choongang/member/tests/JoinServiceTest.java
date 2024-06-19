package org.choongang.member.tests;

import com.github.javafaker.Faker;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.services.JoinService;
import org.choongang.member.validators.JoinValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) //모의객체 사용
@DisplayName("회원가입 기능 테스트")
public class JoinServiceTest {

    private JoinService joinService;
    @BeforeEach
    void init(){
        joinService = new JoinService(new JoinValidator());
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
           JoinService joinService = new JoinService(new JoinValidator());
           joinService.process(getData());
        });
    }

    @Test
    @DisplayName("필수 입력항목(이메일, 비밀번호, 비밀번호확인, 회원명, 약관동의)검증, 검증 실패시 BadRequestException발생")
    void requiredFieldTest(){
        //문제가 있는 경우 상황에 따라서 응답코드 던져주기
        //Bad request -> 400
        assertThrows(BadRequestException.class, ()->{ //예외 발생해야 통과됨
            RequestJoin form = getData();
            form.setEmail(null);
            joinService.process(form);
        });
    }
}
