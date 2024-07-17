package org.choongang.member.api.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.member.entities.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@RequestMapping("/api/member")
@RestController
@RequiredArgsConstructor
public class ApiMemberController {
    //private final MemberMapper mapper;

    @GetMapping("/info/{email}")
    public void info(@PathVariable("email")String email){
        // Content-Type: application/json
       // Member member = mapper.get(email);

       // return member;
    }

    @GetMapping("/list")
    public List<Member> list(){
        List<Member> members = IntStream.rangeClosed(1,10)
                .mapToObj(i -> Member.builder()
                        .email("user"+i+"@test.org")
                        .password("12345678")
                        .userName("사용자"+i)
                        .regDt(LocalDateTime.now())
                        .build())
                .toList();

        return members;
    }

    @GetMapping(value = "/test", produces = "text/html;charset=UTF-8")
    public String test(){
        //content-type: text/plain
        return "안녕하세요!"; //문자열 경로를 반환하게 되면 문자열 그 자체를 반환
    }

    @GetMapping("/test2")
    public void test2(){
        log.info("test2.....");
    }

}
