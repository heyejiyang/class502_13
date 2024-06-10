package member.services;

import global.exceptions.ValidationException;
import global.validators.Validator;
import jakarta.servlet.http.HttpServletRequest;
import member.validators.LoginValidator;

public class LoginService {

    private Validator<HttpServletRequest> validator;

    public LoginService(Validator<HttpServletRequest> validator){
        this.validator = validator; //의존성 주입
    }

    //HttpServletRequest 인터페이스: 사용자 요청 데이터 조회, 처리
    public void process(HttpServletRequest request){//사용자가 입력한 데이터 조회할 수 있는 객체 넘겨줌

        validator.check(request);
    }
}
