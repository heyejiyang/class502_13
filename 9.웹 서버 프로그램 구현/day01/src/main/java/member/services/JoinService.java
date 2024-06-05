package member.services;

import global.validators.Validator;
import member.controllers.RequestJoin;

public class JoinService {

    private Validator<RequestJoin> validator;
    //공통된 상위클래스.. 직접 참조 x 상위클래스 참조하기, 의존역전의 원칙
    //통제 가능하도록 확장엔 열려있고.. 개방폐쇄의원칙..

    public JoinService(Validator<RequestJoin> validator){//통제가 가능하도록
        this.validator = validator;

    }
    public void process(RequestJoin form){
        validator.check(form);
    }

//    //회원가입 기능
//    public void process(RequestJoin form){
//    //이메일 검증
//        String email = form.getEmail();
//        //null이거나 공백일 경우 체크
//        if(email == null || email.isBlank()){
//            throw new ValidationException("이메일을 입력하세요."); //예외던짐
//        }
//    //비밀번호 검증
//        String password = form.getPassword();
//        if(password == null || password.isBlank()){
//            throw new ValidationException("비밀번호를 입력하세요.");//동일구조...
//        }
//        //다른 검증도 이러한 동일 구조 반복될거임...
//        //...
//        //...
//    }
}
