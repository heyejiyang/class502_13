package member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HttpSession session;

    @GetMapping("/member/join")
    public String join(@RequestParam(value = "name", defaultValue = "기본값") String name){ //@RequestParam -> 요청 데이터 이름 명시 하면 뒤에 name변수에 대입

        System.out.println("name: "+name);
        return "member/join";
    }

    @PostMapping("/member/join")
    public String joinPs(RequestJoin form, HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model, Errors errors){
        System.out.println(form);
        return "member/join";
    }
}
