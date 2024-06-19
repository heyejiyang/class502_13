package org.choongang.member.tests;

import org.choongang.member.services.JoinService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) //모의객체 사용
@DisplayName("회원가입 기능 테스트")
public class JoinServiceTest {

    @Test
    @DisplayName("회원가입 성공시 예외가 발생하지 않음")
    void successTest(){
        assertDoesNotThrow(()->{
           JoinService joinService = new JoinService();
           joinService.process();
        });
    }

    @Test
    @DisplayName("필수 입력항목(이메일, 비밀번호, 비밀번호확인, 회원명, 약관동의)검증, 검증 실패시 BadRequestException발생")
    void requiredFieldTest(){
        //문제가 있는 경우 상황에 따라서 응답코드 던져주기
        //Bad request -> 400


    }
}
