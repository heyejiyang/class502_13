package org.choongang.member.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.exceptions.CommonException;
import org.choongang.member.services.LoginService;
import org.choongang.member.services.MemberServiceProvider;

import java.io.IOException;

import static org.choongang.global.MessageUtil.alertError;
import static org.choongang.global.MessageUtil.go;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/member/login.jsp");
        rd.forward(req, resp);
        //RequestDispatcher를 사용하여 /WEB-INF/templates/member/login.jsp 경로의 JSP 파일로 요청을 포워드
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //로그인폼제출 처리
        try {
            LoginService service = MemberServiceProvider.getInstance().loginService();
            service.process(req); //로그인 검증 처리

            //로그인 성공시 하단 메서드 실행
            //클라이언트를 지정된 URL로 이동시키는 역할을 함
            go(req.getContextPath() + "/", "parent", resp);
            //reg.getContextPath는 현재 웹 애플리케이션의 context경로 반환 ex) day07
            //parent -> 현재 프레임의 부모창을 의미, 따라서 부모창에서 URL을 변경하게 된다.
        } catch (CommonException e) {
            alertError(e, resp); //에러처리, 알림창띄움
        }
    }
}