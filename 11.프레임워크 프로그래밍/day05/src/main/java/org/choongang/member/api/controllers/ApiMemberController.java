package org.choongang.member.api.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.services.JoinService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@RequestMapping("/api/member")
@RestController
@RequiredArgsConstructor
public class ApiMemberController {
    private final MemberMapper mapper;
    private final JoinService joinService;

    @PostMapping //POST /api/member -> 회원가입으로 동작
    public ResponseEntity join(@RequestBody RequestJoin form)
    {
        joinService.process(form);

        // 응답코드 201, 출력 바디 없음
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/info/{email}")
    public Member info(@PathVariable("email")String email){
         //Content-Type: application/json
        Member member = mapper.get(email);

        return member;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Member>> list(){
        List<Member> members = IntStream.rangeClosed(1,10)
                .mapToObj(i -> Member.builder()
                        .email("user"+i+"@test.org")
                        .password("12345678")
                        .userName("사용자"+i)
                        .regDt(LocalDateTime.now())
                        .build())
                .toList();

        HttpHeaders headers = new HttpHeaders();//헤더
        headers.add("t1","v1");
        headers.add("t2","v2");

        return  new ResponseEntity<>(members, headers ,HttpStatus.OK);
        //상세하게 응답 작성하고 싶을때
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
