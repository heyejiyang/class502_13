package org.choongang.member.validators;

import lombok.RequiredArgsConstructor;
import org.choongang.member.controller.RequestJoin;
import org.choongang.member.controller.RequestLogin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class LoginValidator implements Validator{

    private final MemberMapper memberMapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestLogin.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(errors.hasErrors()){
            return;
        }
        /**
         * 1) email로 회원이 조회 되는지 검증
         * 2) 조회된 회원의 비밀번호가 입력한 값과 일치하는지 검증
         */

        RequestLogin form = (RequestLogin) target;
        String email = form.getEmail();
        String password = form.getPassword();

        if(StringUtils.hasText(email)){
            Member member = memberMapper.get(email);

            if(member == null){
                errors.reject("Check.emailPassword");
            }

            if(member != null && StringUtils.hasText(password) && !BCrypt.checkpw(password,member.getPassword())){
                errors.reject("Check.emailPassword");
            }
        }
    }
}
