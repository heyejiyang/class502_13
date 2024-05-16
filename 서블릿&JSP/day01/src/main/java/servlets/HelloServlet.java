package servlets;

import jakarta.servlet.ServletConfig;
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
        //System.out.println("안녕하세요!");
        System.out.println("do get 메서드 !!!");
        String common1 = req.getServletContext().getInitParameter("common1");
        System.out.println(common1);
    }

    @Override
    public void destroy() {
        System.out.println("destroy!!!");
    }

//    @Override
//    public void init() throws ServletException {
//        System.out.println("init!!!");
//    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        String key1 = config.getInitParameter("key1");
        String key2 = config.getInitParameter("key2");
        System.out.printf("key1=%s, key2=%s\n",key1,key2);

    }

}
