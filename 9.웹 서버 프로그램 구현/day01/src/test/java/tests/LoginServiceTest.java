package tests;

import jakarta.servlet.http.HttpServletRequest;
import member.services.JoinService;
import member.services.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LoginServiceTest {

    private LoginService loginService;
    private HttpServletRequest request;

    @BeforeEach
    void init(){
        loginService = new LoginService();
    }

    @Test
    @DisplayName("로그인 성공시 예외가 발생하지 않음")
    void successTest(){
        //예외가 발생하지 않았을때 통과
        assertDoesNotThrow(() -> {
            loginService.process(request);
        });
    }
}
