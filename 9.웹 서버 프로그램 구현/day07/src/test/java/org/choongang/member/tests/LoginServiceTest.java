package org.choongang.member.tests;


import com.github.javafaker.Faker;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.choongang.member.services.MemberServiceProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("로그인 기능 테스트")
public class LoginServiceTest {

    //모의객체
    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;
    /*
    HttpSession 객체는 Java EE(Servlet API)에서 제공하는 인터페이스로, 웹 애플리케이션에서 사용자별로 데이터를 저장하고 관리하는 데 사용됨, 세션은 주로 사용자 로그인 상태, 장바구니 정보 등과 같은 사용자별 데이터를 저장
     */

    private Faker faker; //자주 사용되까 객체 따로 만듦

    private RequestJoin form;

    private SqlSession dbsession;

    //매번 테스트할때마다 객체 생성할수 있게 넣어줌
    private LoginService loginService;
    @BeforeEach
    void init(){
        //객체 조립기에서 loginService객체 추가
        loginService = MemberServiceProvider.getInstance().loginService();

        JoinService joinService = MemberServiceProvider.getInstance().joinService();

        //성공데이터(가짜 데이터)
        faker = new Faker(Locale.ENGLISH); //데이터는 영어로

        //환경변수에 따라 바뀜
        dbsession = MemberServiceProvider.getInstance().getSession();

        //회원 가입 -> 가입한 회원 정보로 email, password 스텁 생성
        //중복 안시키기 위해 millis추가
        form = RequestJoin.builder()
                .email(System.currentTimeMillis()+faker.internet().emailAddress())
                .password(faker.regexify("\\w{8,16}").toLowerCase()) //8자리부터 16자리까지
                .userName(faker.name().fullName())
                .termsAgree(true)
                .build();
        form.setConfirmPassword(form.getPassword());
        joinService.process(form); //이 데이터를 바탕으로 로그인 할 예정..

        setData(); //데이터 항상 초기화시켜주기 위해

        //모의객체 세션넣어주기
        given(request.getSession()).willReturn(session);
        //request 객체의 getSession() 메서드가 호출되었을 때, 실제 세션 객체 대신 모의된 session 객체를 반환하도록 설정

        /*
        given -> 모키토 라이브러리의 메서드
        - request.getSession 호출시 호출시 session 반환
        - request.getSession은 Http 요청에서 세션 객체를 가져오는 메서드임, 세션 객체는 사용자 정보를 저장하거나 관리하는데 사용됨
        - willReturn(session)은 given()과 함께 사용되어, request.getSession()이 호출될 때 반환될 값을 지정, 여기서는 session이라는 모의 객체가 반환되도록 설정
         */
    }

    void setData(){
        setParam("email", form.getEmail()); //실제 가입한 데이터로 체크
        setParam("password", form.getPassword());
    }

    //가짜데이터 만드는 메서드
    //request.getParameter(name) 호출 시 value를 반환하도록 설정
    void setParam(String name, String value){
        //가짜 데이터 스텁 생성
        given(request.getParameter(name)).willReturn(value);
        //request 객체의 getParameter 메서드가 name 파라미터로 호출될 때 value 값을 반환하도록 설정
    }

    @Test
    @DisplayName("로그인 성공시 예외가 발생하지 않음")
    void successTest(){
        //예외발생 없으면 통과
        assertDoesNotThrow(()->{
           loginService.process(request); //로그인 기능 처리
        });

        //로그인 처리 완료시 HttpSession - setAttribute 메서드가 호출됨
        //setAttribute가 호출 되었는지 체크
        //세션쪽 값 호출 한번만.. -> only
        then(session).should(only()).setAttribute(any(),any());
        /*
        then() 은 모키토에서 쓰는건데
        then(session) -> session객체의 행동을 확인 or 검증 준비
        - 즉 then 메서드는 session 객체에 대한 행동을 검증할때 사용
        should() -> 모키토 라이브러리 객체 특정 메서드 호출되었는지 확인해주는 메서드
        - session 객체의 메서드 호출을 검증하는 역할을 함
        only() -> 세션 객체에서 특정 메서드가 오직 한번만 호출되었는지 검증함
        - 즉 세션 객체에서 setAttribute 메서드가 한번만 호출되었고 다른 메서드는 호출되지 않았음을 보장
        setAttribute(any(),any()) -> session 객체의 setAttribute 메서드가 호출되었는지를 검증
        - any 메서드는 매개변수로 어떤 값이든 허용한다는 의미, 2개의 매개변수를 사용하여 호출됨을 확인
        이 코드는 session 객체가 setAttribute 메서드를 사용하여 "member"라는 이름의 속성에 어떤 값이라도 설정하는 동작이 있었는지를 검증
         */
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
    void memberExistTest() {
        setParam("email", "****" + form.getEmail());
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            loginService.process(request);
            //첫번째 매개변수의 예외와 같은 예외 발생시 테스트 통과
        });
        String message = thrown.getMessage();
        assertTrue(message.contains("이메일 또는 비밀번호"));
        //message객체에 아이디 또는 비밀번호 문구가 담겨있다면 true로 통과
    }

    @Test
    @DisplayName("비밀번호 검증, 검증 실패시 BadRequestException")
    void passwordCheckTest(){
        setParam("password","****"+form.getPassword());
        BadRequestException thrown = assertThrows(BadRequestException.class, ()->{
            loginService.process(request);
        });
        String message = thrown.getMessage();
        assertTrue(message.contains("이메일 또는 비밀번호"));
    }

    @AfterEach
    void destroy(){
        //dbsession.rollback();
    }

}
