package org.choongang.member.services;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.member.controller.RequestLogin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberMapper mapper;
    private final HttpSession session;
    private final HttpServletResponse response;

    public void process(String email){
        Member member = mapper.get(email);
        if(email==null){
            return;
        }
        session.setAttribute("member",member);
    }

    public void process(RequestLogin form){
        process(form.getEmail());

        Cookie cookie = new Cookie("savedEmail",form.getEmail());
        if(form.isSaveEmail()){
            cookie.setMaxAge(60 * 60 * 24 * 7); //7일간 쿠키 유지
        }else {
            cookie.setMaxAge(0);
        }

        response.addCookie(cookie);
    }
}
