package org.choongang.member.validators;

import lombok.RequiredArgsConstructor;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.mappers.MemberMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator {
    private final MemberMapper memberMapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestJoin.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        /*
         * 1. 필수 항목 검증 (email, password, confirmPassword, userName, agree)
         * 2. email 중복 여부
         * 3. 비밀 번호 자리수 체크(8자리)
         * 4. 비밀 번호, 비밀 번호 확인 일치 여부
         *
         * */
        RequestJoin form = (RequestJoin) target;
        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String userName = form.getUserName();
        boolean agree = form.isAgree();

//      2. 이메일 중복 여부
        if (StringUtils.hasText(email) && memberMapper.exists(email) != 0L) {
            errors.rejectValue("email", "Duplicated");
        }
        if (StringUtils.hasText(password) && StringUtils.hasText(confirmPassword) && !password.equals(confirmPassword)) {
            errors.rejectValue("confirmPassword", "Mismatch");
        }
//        4. 비밀 번호, 비밀 번호 확인 일치 여부
    }
}
