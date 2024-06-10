package member.validators;

import global.validators.Validator;
import jakarta.servlet.http.HttpServletRequest;
import member.services.LoginService;

public class LoginValidator implements Validator<HttpServletRequest> {

    //통일된 규칙으로 검증 -> 인터페이스 구현체
    @Override
    public void check(HttpServletRequest form) {

    }

}
