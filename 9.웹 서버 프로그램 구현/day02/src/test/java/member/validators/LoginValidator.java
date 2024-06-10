package member.validators;

import global.exceptions.ValidationException;
import global.validators.Validator;
import jakarta.servlet.http.HttpServletRequest;
import member.services.LoginService;

public class LoginValidator implements Validator<HttpServletRequest> {

    //통일된 규칙으로 검증 -> 인터페이스 구현체
    @Override
    public void check(HttpServletRequest form) {
        String email = form.getParameter("email");
        if(email == null || email.isBlank()){
            throw new ValidationException("이메일을 입력하세요.");
        }
    }

}
