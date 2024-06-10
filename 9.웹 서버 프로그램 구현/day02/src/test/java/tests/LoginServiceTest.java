package tests;


import member.services.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로그인 서비스 기능 테스트")
public class LoginServiceTest {

    private LoginService loginService;

    //테스트전에 매번 쓸 객체나 필요할 부분 초기화
    //테스트 할때마다 객체를 생성할것임
    @BeforeEach
    void init(){
        loginService = new LoginService();
    }

    @Test
    @DisplayName("로그인 성공시 예외 발생 없음")
    void successTest(){ //테스트는 항상 통과가 가장 쉬운 테스트부터
        assertDoesNotThrow(()->{
            loginService.process();
        }); //예외 발생 없으면 통과
    }
}
