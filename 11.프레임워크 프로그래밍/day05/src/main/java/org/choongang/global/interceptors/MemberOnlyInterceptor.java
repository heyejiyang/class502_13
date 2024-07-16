package org.choongang.global.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 회원 전용 페이지 관련 인터셉터
 * HandlerInterceptor 안에 메서드는 전부 default메서드 원하는 메서드 가져다 쓰면 됨
 * preHandle 제일 많이 씀 - 컨트롤러 실행 전에 공통 처리 + 통제
 */

@Slf4j
@Component
public class MemberOnlyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("preHandle()");

        //로그인이 아닐때는 페이지가 보이지 않도록 처리

        HttpSession session = request.getSession(); //세션 객체 가져옴
        if(session.getAttribute("member") != null){ //로그인 상태인 경우
            return true; //컨트롤러 빈 메서드 실행
        }

        response.sendRedirect(request.getContextPath()+"/member/login");

        return false; //미 로그인 상태 - 로그인 페이지로 이동시키기
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("message","postHandle!");
        //속성값을 뷰 페이지에 넘길수 있다

        log.info("postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       //예외가 없는 경우는 null값, 오류가 나온다면 오류에 대한 정보 Exception에 담김

        log.info("afterCompletion()");
    }

}
