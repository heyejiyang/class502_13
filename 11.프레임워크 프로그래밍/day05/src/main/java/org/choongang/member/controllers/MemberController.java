package org.choongang.member.controllers;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join") //핸들러 매핑이 요청 url과 매칭되는 컨트롤러 찾아줌
//    @RequestMapping(path = "/member/join", method = {RequestMethod.GET,RequestMethod.POST}) //두개의 요청을 가져올 수 있는 상태
    public String join(Model model, HttpServletRequest request){
//        model.addAttribute("member", "안녕하세요.");
//        //jsp에서 el식으로 접근 가능
//
//        System.out.println("method: "+request.getMethod());
        return "member/join";
    }

    @PostMapping("/join")//Post방식 처리시 여기로 유입됨
    public String joinPs(RequestJoin form){
        return "redirect:/member/login";
    }


//@GetMapping("/member/join")
//public ModelAndView join(){
//    ModelAndView mv = new ModelAndView();
//    mv.addObject("member", "안녕하세요.");
//    mv.setViewName("member/join");
//
//    return mv;
//}

}
