package member.validators;

import global.exceptions.ValidationException;
import global.validators.Validator;
import jakarta.servlet.http.HttpServletRequest;
import member.services.LoginService;

public class LoginValidator implements Validator<HttpServletRequest> , RequiredValidator{

    //통일된 규칙으로 검증 -> 인터페이스 구현체
    @Override
    public void check(HttpServletRequest form) {
        String email = form.getParameter("email");
        String password = form.getParameter("password");

        /*필수항목검증 S*/
        checkRequired(email, new ValidationException("이메일을 입력하세요."));
        checkRequired(password, new ValidationException("비밀번호를 입력하세요."));
        /*필수항목검증 E*/


    }

}
