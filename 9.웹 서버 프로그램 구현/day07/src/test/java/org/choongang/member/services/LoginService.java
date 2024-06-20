package org.choongang.member.services;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.validators.Validator;
import org.choongang.member.mapper.MemberMapper;

public class LoginService {

    //의존역전, 개방폐쇄 원칙 적용
    private Validator<HttpServletRequest> validator;
    private MemberMapper mapper;

    public LoginService(Validator<HttpServletRequest> validator, MemberMapper mapper) {
        this.validator = validator;
        this.mapper = mapper;
    }

    public void process(HttpServletRequest request){ //로그인 기능 서비스
        //로그인 유효성 검사
        validator.check(request);
    }
}
