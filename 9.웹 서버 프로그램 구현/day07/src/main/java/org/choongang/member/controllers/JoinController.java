package org.choongang.member.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.exceptions.CommonException;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.MemberServiceProvider;

import java.io.IOException;
import java.io.PrintWriter;

import static org.choongang.global.MessageUtil.alertError;
import static org.choongang.global.MessageUtil.go;

/*
회원가입 컨트롤러
 */
@WebServlet("/member/join")
public class JoinController extends HttpServlet { //상속받으면 얘는 서블릿 클래스가 되는거


    //양식
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/member/join.jsp"); //버퍼추가

        rd.forward(req, resp); //버퍼치환
    }

    //처리
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            JoinService joinService = MemberServiceProvider.getInstance().joinService();
            //RequestJoin(DTO)에서 setter을 통해 데이터를 다 넣어주는건 번거롭다.. 수정수정

            joinService.process(req); //사용자 요청을 process에 넘겨주기!
            //요청데이터 들어오면 DTO로 변환작업

            //회원가입 성공시 하단 메서드 실행
            //클라이언트를 지정된 URL로 이동시키는 역할을 함
            //자바스크립트 형태로 페이지이동
            go(req.getContextPath()+"/member/login","parent",resp);
            //reg.getContextPath는 현재 웹 애플리케이션의 context경로 반환 ex) day07
            //parent -> 현재 프레임의 부모창을 의미, 따라서 부모창에서 URL을 변경하게 된다.

            //resp.sendRedirect(req.getContextPath()+"/member/login");
        }catch(CommonException e){
            alertError(e,resp);
        }

    }
}
