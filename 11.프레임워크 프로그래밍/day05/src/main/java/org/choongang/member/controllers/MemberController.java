package org.choongang.member.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.validators.LoginValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final JoinValidator joinValidator; //의존성
    private final JoinService joinService;
    private final LoginService loginService;
    private final LoginValidator loginValidator;

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form){ //회원가입 양식

        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors){ //양식 제출
        //회원가입 form 에서 post 요청시 검증
        //회원가입 데이터 검증
        joinValidator.validate(form, errors);

        if(errors.hasErrors()){ //reject, rejectValue가 한번이라도 호출되면 true
            //검증 실패시 다시 양식 보여줌
            return "member/join";
        }

        joinService.process(form); //회원가입 처리

        //검증 이상 없으면 이동
        return "redirect:/member/login"; //회원가입 양식 제출 시 로그인 페이지로 리다이렉트
    }

    @GetMapping("/login")
    public String login(@ModelAttribute RequestLogin form,
                        @CookieValue(name = "saveEmail",required = false) String savedEmail/*@SessionAttribute(name = "member",required = false) Member member*/)
    {
//        if(member != null) {
//            log.info(member.toString());
//        }
        if(savedEmail != null){
            form.setSaveEmail(true);
            form.setEmail(savedEmail);
        }
        return "member/login";
    }


    @PostMapping("/login")
    public String loginPs(@Valid RequestLogin form, Errors errors) {

        loginValidator.validate(form, errors);

        if (errors.hasErrors()) {
            return "member/login";
        }

        //로그인 처리
//        String email = form.getEmail();
        loginService.process(form);

        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate(); //세션 비우기

        return "redirect:/member/login";
    }

    /*
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(joinValidator);
    }*/
}