package org.choongang.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.member.services.JoinService;
import org.choongang.member.validators.JoinValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final JoinValidator joinValidator;
    private final JoinService joinService;

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form){
        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors){
        log.info(form.toString());

        joinValidator.validate(form,errors);

        if(errors.hasErrors()){
            return "member/join";
        }

        joinService.process(form);//회원가입 처리

        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login() {
        return "/member/login";
    }
}
