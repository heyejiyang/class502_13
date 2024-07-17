package org.choongang.global.advices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.choongang.global.exceptions.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice("org.choongang")//공통 처리 할 경로
public class CommonControllerAdvice {

    @ExceptionHandler(Exception.class) //발생할 예외정보 클래스 정의(여러개 가능)
    public ModelAndView errorHandler(Exception e, HttpServletRequest request, HttpServletResponse response, Model model){
        e.printStackTrace();
        log.info("advice 유입");

        //기본 상태코드 500으로 설정하고 예외 객체에 상태코드가 있으면 바꿔주는 형식으로 만들기
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; //500
        //instanceof로 객체 체크
        if(e instanceof CommonException commonException){
            //CommonException commonException = (CommonException) e;
            status = commonException.getStatus();
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("error/common");
        mv.setStatus(status); //응답코드

        return mv;
    }
}
