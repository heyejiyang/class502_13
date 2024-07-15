package org.choongang.member.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.member.validators.JoinValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final JoinValidator joinValidator; //의존성

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form){ //회원가입 양식

        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(RequestJoin form, Errors errors){ //양식 제출
        //회원가입 form 에서 post 요청시 검증
        //회원가입 데이터 검증
        joinValidator.validate(form, errors);

        if(errors.hasErrors()){ //reject, rejectValue가 한번이라도 호출되면 true
            //검증 실패시 다시 양식 보여줌
            return "member/join";
        }

        //검증 이상 없으면 이동
        return "redirect:/member/login"; //회원가입 양식 제출 시 로그인 페이지로 리다이렉트
    }

}
