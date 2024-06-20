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
        }catch(CommonException e){
            resp.setContentType("text/html;charset=UTF-8");
            resp.setStatus(e.getStatus()); //응답코드 400
            //스크립트태그형태로 화면 출력
            PrintWriter out = resp.getWriter();
            out.printf("<script>alert('%s');</script>", e.getMessage());
        }

    }
}
