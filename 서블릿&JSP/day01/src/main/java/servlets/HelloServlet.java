package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HelloServlet extends HttpServlet { //웹기술 동작을 위한 상속, 자바의 웹기술로서쓸수있는 클래스가 된다.
    //요청 메서드 do ~

    //서블릿은 다양하게 공유되야하니 접근제어자 public으로 바꿔주자
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("안녕하세요!");
    }
}
