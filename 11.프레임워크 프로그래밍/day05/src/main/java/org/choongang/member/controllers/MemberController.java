package org.choongang.member.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/member/join") //핸들러 매핑이 찾아줌
    public String join(){
        return "member/join";
    }
}
