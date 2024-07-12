package org.choongang.member.controllers;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Locale;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MessageSource messageSource;
    private final HttpServletRequest request;

    @ModelAttribute("commonValue") //컨트롤러에서 공통으로 지정할 수 있는 속성값 ,이름 명시해줌
    public String commonValue(){
        return "공통 속성 값..";
    }

    @ModelAttribute("hobbies") //공통 속성 추가
    public List<String> hobbies(){
        return List.of("취미1","취미2","취미3","취미4");
    }

    @ModelAttribute("hobbies2")
    public List<CodeValue> hobbies2(){
        return List.of(
                new CodeValue("취미1","hobby1"),
                new CodeValue("취미2","hobby2"),
                new CodeValue("취미3","hobby3")
        );
    }

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form) { // 값이 없을때 RequestJoin 이름을 가지고 앞자를 소문자로 바꿔서 자동으로 만들어줌
        Locale locale  = request.getLocale(); //요청 헤더 Accept-Language
        String message = messageSource.getMessage("EMAIL", null, locale);
        log.info(message);
        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(RequestJoin form){ //같은 이름의 setter가 있으면 알아서 값을 대입해준다.
        log.info(form.toString()); //폼에 작성한 요청 데이터 넘어오는지 확인
        return "member/join";
       //return "redirect:/member/login"; //Location 헤더: /day05/member/login //주소이동
       // return "forward:/member/login"; //버퍼치환
    }

    @GetMapping("/login")
    public String login(RequestLogin2 form){
        if(form != null){
            log.info("이메일:{}, 비밀번호:{}", form.email(), form.password());
            //변경불가 조회만 가능
        }
        return "member/login";
    }

//    @GetMapping("/join" )
//    public String join1(Model model, HttpServletRequest request){
//        log.info("{},{} 없음", "mode1","mode2");
//        return "member/join";
//    }
//
//    @GetMapping(path="/join",params ={"mode=join"} ) //mode값에 반드시 join이 있어야지 여기로 유입이 된다.
//    public String join(Model model, HttpServletRequest request){
//        log.info("mode=join");
////        model.addAttribute("member", "안녕하세요.");
////        //jsp에서 el식으로 접근 가능
////
////        System.out.println("method: "+request.getMethod());
//        return "member/join";
//    }
//
//    @PostMapping(value = "/join", headers = "appKey=1234", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public String joinPs(RequestJoin form){
//        log.info("JoinPs실행...");
//        return "redirect:/member/login"; // 절대경로 기준 이동
//       // return "redirect:member/login"; // 상대 경로 기준 이동
//    }


//@GetMapping("/member/join")
//public ModelAndView join(){
//    ModelAndView mv = new ModelAndView();
//    mv.addObject("member", "안녕하세요.");
//    mv.setViewName("member/join");
//
//    return mv;
//}

}
