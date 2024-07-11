package org.choongang.member.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/member/join") //핸들러 매핑이 요청 url과 매칭되는 컨트롤러 찾아줌
    public String join(){
        return "member/join";
    }
}
