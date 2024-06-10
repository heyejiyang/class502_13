package exam01;

import com.github.javafaker.Faker;
import global.Mailer;
import jakarta.servlet.http.HttpServletRequest;
import member.services.LoginService;
import member.validators.LoginValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class Ex02Test {

    private LoginService loginService;
    private Mailer mailer;

    private Faker faker;
    private HttpServletRequest request;

    @BeforeEach
    void init(){
        loginService = new LoginService(new LoginValidator());
        mailer = mock(Mailer.class);

        faker = new Faker(Locale.ENGLISH);

        request = mock(HttpServletRequest.class);//가짜 객체 생성


        //가짜데이터 스텁 추가
        given(request.getParameter("email")).willReturn(faker.internet().emailAddress());
        given(request.getParameter("password")).willReturn(faker.regexify("\\w{8}").toLowerCase());//정규표현식

    }

    @Test
    void test1(){
        loginService.setMailer(mailer);//mailer객체가 할당되면 null이 아니기때문에 then에서 호출이 잘 될것
        loginService.process(request);

        String email = request.getParameter("email");
        then(mailer).should().send(email); //모의 객체 넣어주기
        //should -> 적어도 한번이상 호출
        //send 함수가 loginService.process 메서드에서 한번 이상 호출되는지 테스트

    }
}
