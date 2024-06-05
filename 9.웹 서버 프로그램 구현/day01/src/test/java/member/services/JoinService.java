package member.services;

import global.exceptions.ValidationException;
import member.controllers.RequestJoin;

public class JoinService {
    //회원가입 기능
    public void process(RequestJoin form){
    //이메일 검증
        String email = form.getEmail();
        //null이거나 공백일 경우 체크
        if(email == null || email.isBlank()){
            throw new ValidationException("이메일을 입력하세요."); //예외던짐
        }
    //비밀번호 검증
        String password = form.getPassword();
        if(password == null || password.isBlank()){
            throw new ValidationException("비밀번호를 입력하세요.");//동일구조...
        }
        //다른 검증도 이러한 동일 구조 반복될거임...
        //...
        //...
    }
}
