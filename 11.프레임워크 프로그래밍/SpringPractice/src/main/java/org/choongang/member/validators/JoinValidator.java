package org.choongang.member.validators;

import lombok.RequiredArgsConstructor;
import org.choongang.member.controller.MemberController;
import org.choongang.member.controller.RequestJoin;
import org.choongang.member.mappers.MemberMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator {

    private final MemberMapper mapper;
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestJoin.class);
        //검증하려는 클래스 체크
    }

    @Override
    public void validate(Object target, Errors errors) {
        /*
        * Object target: 커맨드 객체(형변환을 통해서 내가 원하는 커맨드 객체로 씀)
          Errors errors: 검증 실패시 전달할 메시지 등록
        * */
        //검증로직

        RequestJoin form = (RequestJoin) target;
        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String userName = form.getUserName();
        boolean agree = form.isAgree();


//        if(!StringUtils.hasText(email)){
//            errors.rejectValue("email","Required","이메일을 입력하세요.");
//        }
//
//        if(!StringUtils.hasText(password)){
//            errors.rejectValue("password","Required","비밀번호를 입력하세요.");
//        }

        //필수항목 검증
        /*
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","Required","이메일을 입력하세요.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","Required","비밀번호를 입력하세요.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"confirmPassword","Required","비밀번호를 확인하세요.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userName","Required","회원명을 입력하세요.");

        if(!agree){
            errors.rejectValue("agree","Required","회원가입 약관에 동의하세요.");
        }*/

        //이메일 중복 여부
        if(StringUtils.hasText(email) && mapper.exists(email) != 0L){ //null이 아니고 공백이 아닌 + 데이터베이스에 이미 존재 할 경우
            errors.rejectValue("email","Duplicated");
        }

        /*
        //비밀번호 자리수 체크
        if(StringUtils.hasText(password) && password.length() <8){
            errors.rejectValue("password","Length");
        }
        */

        //비밀번호, 비밀번호 확인 일치 여부
        if(StringUtils.hasText(password) && StringUtils.hasText(confirmPassword) && !password.equals(confirmPassword)){
            errors.rejectValue("confirmPassword","Mismatch");
        }


    }
}
