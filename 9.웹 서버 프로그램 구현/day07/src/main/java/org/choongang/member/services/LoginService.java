package org.choongang.member.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.choongang.global.validators.Validator;
import org.choongang.member.entities.Member;
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

        //이미 검증이 끝난 후 로직이기 때문에
        // 현 로직으로 온다는것은 이메일이 존재한 상태
        //로그인 처리 - 회원정보 조회, 세션에 유지
        String email = request.getParameter("email");
        Member member = mapper.get(email);

        //세션을 통해서 이 값을 유지하면 됨
        HttpSession session = request.getSession();
        session.setAttribute("member", member);

    }
}
