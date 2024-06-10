package tests;


import com.github.javafaker.Faker;
import global.exceptions.ValidationException;
import jakarta.servlet.http.HttpServletRequest;
import member.services.LoginService;
import member.validators.LoginValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("로그인 서비스 기능 테스트")
public class LoginServiceTest {

    private LoginService loginService;
    private HttpServletRequest request; //사용자 요청 객체
    private Faker faker;

    //테스트전에 매번 쓸 객체나 필요할 부분 초기화
    //테스트 할때마다 객체를 생성할것임
    @BeforeEach
    void init(){
        loginService = new LoginService(new LoginValidator());

        //모의 객체 mock()... 인터페이스 객체 필요
        //HttpServletRequest 모의 객체 생성
        request = mock(HttpServletRequest.class);//내가 만들고자 하는 모의객체 정보를 알려줘야함 class 클래스(정보성 객체)
        faker = new Faker(Locale.KOREAN);
    }

    void setParamData(String name, String value){
        given(request.getParameter(name)).willReturn(value);
    }

    //성공시 데이터
    void setSuccessData(){
        String password = faker.regexify("\\w{8}]").toLowerCase();//정규표현식
        setParamData("email", faker.internet().emailAddress()); //가짜데이터 넣기
        setParamData("password",password);
    }

    @Test
    @DisplayName("로그인 성공시 예외 발생 없음")
    void successTest(){ //테스트는 항상 통과가 가장 쉬운 테스트부터
        assertDoesNotThrow(()->{
            setSuccessData();
            loginService.process(request);
        }); //예외 발생 없으면 통과
    }

    @Test
    @DisplayName("필수 항목(아이디, 비밀번호) 검증, 검증 실패시 ValidationException 발생")
    void requiredFieldTest(){
        //아이디 필수 항목 검증 -null, 비어있는값 체크
        ValidationException thrown = assertThrows(ValidationException.class,()->{
            setParamData("email",faker.internet().emailAddress());
           loginService.process(request);
        });//실패시 예외 발생 후 통과, 실패하니 통과다!!! 예외발생!! 성공 아님!!
        //검증하는 이유는 잘못된 데이터 들어왓을때 예외발생이 제대로 이루어지는지 체크하는것

        String message = thrown.getMessage();
        assertTrue(message.contains("이메일")); //이메일이 포함되어있으면 true반환
    }
    void requiredFieldEachTest(String name, String message){
        setParamData("email",null);
        setParamData("password",null);
        ValidationException thrown = assertThrows(ValidationException.class,()->{
            //null일때 검증
            loginService.process(request);
            //비어있는값일때 검증
            setParamData(name,"   ");
            loginService.process(request);
        }, message+" 테스트");
        //메시지 검증
        String msg = thrown.getMessage();
        assertTrue(msg.contains(message), message+" 테스트"); //실패시 문구
    }
}
