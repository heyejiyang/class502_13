package org.choongang.global.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class MemberOnlyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle유입");

        HttpSession session = request.getSession();
        //세션이 있으면 기존 세션 반환, 없으면 새로운 세션을 생성해서 반환

        if(session.getAttribute("member") != null){ //세션에 저장된 member 속성 값쌍 가져오기
            //로그인 상태인 경우
            return true;
        }
        response.sendRedirect(request.getContextPath()+"/member/login");

        return false; //컨트롤러 메서드 실행 X, 미로그인상태
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("message","postHandle!!!");

        log.info("postHandle()");
    }
}
