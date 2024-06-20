package org.choongang.member.tests;


import com.github.javafaker.Faker;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.choongang.member.services.MemberServiceProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("로그인 기능 테스트")
public class LoginServiceTest {

    //모의객체
    @Mock
    private HttpServletRequest request;

    private Faker faker; //자주 사용되까 객체 따로 만듦

    private RequestJoin form;

    //매번 테스트할때마다 객체 생성할수 있게 넣어줌
    private LoginService loginService;
    @BeforeEach
    void init(){
        //객체 조립기에서 loginService객체 추가
        loginService = MemberServiceProvider.getInstance().loginService();

        JoinService joinService = MemberServiceProvider.getInstance().joinService();

        //성공데이터(가짜 데이터)
        faker = new Faker(Locale.ENGLISH); //데이터는 영어로

        //회원 가입 -> 가입한 회원 정보로 email, password 스텁 생성
        //중복 안시키기 위해 millis추가
        form = RequestJoin.builder()
                .email(System.currentTimeMillis()+faker.internet().emailAddress())
                .password(faker.regexify("\\w{8,16}").toLowerCase()) //8자리부터 16자리까지
                .userName(faker.name().fullName())
                .build();
        joinService.process(form); //이 데이터를 바탕으로 로그인 할 예정..

        setData(); //데이터 항상 초기화시켜주기 위해
    }

    void setData(){
        setParam("email", faker.internet().emailAddress());
        setParam("password", faker.regexify("\\w{8}.toLowerCase()"));
    }

    //가짜데이터 만드는 메서드
    void setParam(String name, String value){
        //가짜 데이터 스텁 생성
        given(request.getParameter(name)).willReturn(value);
        //request객체의 parameter에 name값이 주어지면 value값을 반환
    }

    @Test
    @DisplayName("로그인 성공시 예외가 발생하지 않음")
    void successTest(){
        //예외발생 없으면 통과
        assertDoesNotThrow(()->{
           loginService.process(request); //로그인 기능 처리
        });
    }

    @Test
    @DisplayName("필수 입력 항목(이메일, 비밀번호) 검증, 검증 실패시 BadRequestException 발생")
    void requiredFieldTest(){
        //웹에서 입력한 데이터 받아서 서비스 처리
        //사용자가 양식을 통해 입력한 데이터 서버로 넘어옴 -> HttpServletRequest 구현 객체로 넘어옴 getParameter(사용자가 보내줌)로 조회/ getAttribute(서버쪽에서 전달한 데이터)

        //값이 null이거나 빈값일때 예외 발생
        assertAll(
                ()-> requiredEachFieldTest("email",false,"이메일"),
                ()-> requiredEachFieldTest("email",true,"이메일"),
                ()-> requiredEachFieldTest("password",false,"비밀번호"),
                ()-> requiredEachFieldTest("password",true,"비밀번호")
        );

    }

    //값이 null이거나 빈값인지 체크
    //문구도 정확하게 나오는지 체크
    void requiredEachFieldTest(String name, boolean isNull, String message){
        //값 초기화
        setData();
        //발생할 예외는 BadRequestException이 되어야 한다.
        BadRequestException thrown = assertThrows(BadRequestException.class, ()->{
            if(name.equals("password")){ //비밀번호 검증
                setParam("password",isNull?null:"   ");
            }else{ //이메일 검증
                setParam("email",isNull?null:"   ");
            }
            loginService.process(request);
        }, name+" 테스트");
        String msg = thrown.getMessage(); //던저진 예외 객체에서 예외 message 저장
        assertTrue(msg.contains(message),name+" 키워드 테스트");
        //true가 나오면 통과
        //msg 객체에 message가 포함되어 있는지 확인 -> true여야 테스트 성공
        //두번째 매개변수: 조건이 false일 경우 출력될 메시지
    }

    @Test
    @DisplayName("이메일로 회원이 조회 되는지 검증, 검증 실패시 BadRequestException 발생")
    void memberExistTest(){

    }

}
