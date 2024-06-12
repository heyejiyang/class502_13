package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String url = req.getRequestURI(); //사용자가 요청한 주소가 뭔지 확인
//        System.out.println(url);

        String mode = getMode(req);
        if(mode.equals("join")){
            joinForm(req,resp);
        }else if(mode.equals("login")){
            loginForm(req,resp);
        }

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = getMode(req);
        if(mode.equals("join")){
            joinProcess(req,resp);
        }else if(mode.equals("login")){
            loginProcess(req,resp);
        }
    }

    private String getMode(HttpServletRequest req){
        String url = req.getRequestURI();
        //url자르기
        String[] urls = url.split("/");
        String mode = urls.length > 0 ? urls[urls.length-1] : ""; //가장끝에있는 문구 나오게함 //값이 없는 경우 대비
        return mode;
    }

    //get방식
    //회원가입 양식
    private void joinForm(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/html;charset-UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>회원가입</h1>");
    }
    //get방식
    //로그인 양식
    private void loginForm(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>로그인</h1>");
    }

    //Post방식
    //회원가입 처리
    private void joinProcess(HttpServletRequest req, HttpServletResponse resp){

    }
    //로그인처리
    private void loginProcess(HttpServletRequest req, HttpServletResponse resp){

    }

}
