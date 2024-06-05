package member.validators;

import global.exceptions.ValidationException;
import global.validators.RequiredValidator;
import global.validators.Validator;
import member.controllers.RequestJoin;

public class JoinValidator implements Validator<RequestJoin>, RequiredValidator {
    @Override
    public void check(RequestJoin form) {
        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfrimPw();
        String userName = form.getUserName();

        /*필수 항목 검증 S*/
        checkRequired(email,new ValidationException("이메일을 입력하세요."));
        checkRequired(password,new ValidationException("비밀번호를 입력하세요."));
        checkRequired(confirmPassword,new ValidationException("비밀번호를 확인하세요."));
        checkRequired(userName,new ValidationException("이름을 입력하세요."));
        /*필수 항목 검증 E*/
    }
}
