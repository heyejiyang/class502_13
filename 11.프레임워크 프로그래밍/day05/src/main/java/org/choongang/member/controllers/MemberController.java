package org.choongang.member.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.member.entities.Member;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.validators.LoginValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

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
                        @CookieValue(name = "savedEmail",required = false) String savedEmail/*@SessionAttribute(name = "member",required = false) Member member*/)
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

    /* 타임리프로 인한 주석..
    /*회원목록
    @GetMapping("/list")
    public String list(@Valid @ModelAttribute MemberSearch search,Errors errors){
        //검증이 필요한 형태임을 알려줌 Valid 애노테이션 추가, 에러 객체 추가

        log.info(search.toString());

        boolean result = false;
        if(!result){
            throw new BadRequestException("예외 발생!!!");
        }

        return "member/list";
    }
    */

    @GetMapping("/list")
    public String list(Model model){

        /*
        Member member = Member.builder()
                .email("user01@test.org")
                .password("12345678")
                .userName("<h1>사용자1</h1>")
                .regDt(LocalDateTime.now())
                .build();

        model.addAttribute("member", member);
        */

        List<Member> items = IntStream.rangeClosed(1,10)
                .mapToObj(i -> Member.builder()
                        .email("user"+i+"@test.org")
                        .userName("사용자"+i)
                        .regDt(LocalDateTime.now())
                        .build())
                .toList();
        model.addAttribute("items", items);
        return "member/list";
    }

    @ResponseBody //반환값을 void로 하기위해 넣은 애노테이션
    @GetMapping({"/info/{id}/{id2}","/info/{id}"}) //경로변수 패턴 - 바뀔 수 있는 부분
    public void info(@PathVariable("id") String email, @PathVariable(name= "id2", required = false) String email2){ //여러개 지정도 가능
        // 값이 없는 주소 대입되었을때 required false로 하면 null값이 들어간다.
        log.info("email:{}, email2:{}",email,email2);

    }

    @ResponseBody
    @GetMapping("/list2")
    public List<Member> list2(){
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

//    @ExceptionHandler(Exception.class) //발생할 예외정보 클래스 정의(여러개 가능)
//    public String errorHandler(Exception e, HttpServletRequest request, HttpServletResponse response, Model model){
//        e.printStackTrace();
//        log.info("MemberController에서 유입");
//        return "error/common"; //위에 예외 클래스 발생시 이 경로로 반환(뷰)
//    }

    /*
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(joinValidator);
    }*/
}