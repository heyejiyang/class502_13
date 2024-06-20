package org.choongang.member.validators;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;

public class LoginValidator implements Validator<HttpServletRequest>, RequiredValidator { //검증하고자하는 전달 객체 지네릭 타입으로 선언
    //RequiredValidator 에는 null이거나 빈값일때 예외처리 메서드, 참인지 체크하는 메서드 들어있음(참이 아니면 예외던짐) (checkedRequired, checkTrue)


    @Override
    public void check(HttpServletRequest form) {
        String email = form.getParameter("email");
        String password = form.getParameter("password");

        //필수항목 검증
        //null값 빈값 검증
        checkRequired(email,new BadRequestException("이메일을 입력하세요."));
        checkRequired(password,new BadRequestException("비밀번호를 입력하세요"));
    }
}
