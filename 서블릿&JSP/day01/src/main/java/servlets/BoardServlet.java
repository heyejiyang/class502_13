package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


@WebServlet("/board")
public class BoardServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); //응답헤더에 html임을 알려줌
        //resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter(); //프린트 형태의 메서드가 정의되어있다.
        /*PrintWriter는 자바에서 출력 스트림을 다루는 클래스 중 하나
        *PrintWriter 객체는 resp.getWriter()를 통해 HttpServletResponse에서 가져옵니다. 이는 클라이언트로부터의 응답을 보낼 때 사용
        * */
        out.print("<form method='post' action='/day01/board'>");
        out.print("제목: <input type='text' name='subject'><br>");
        out.print("내용: <textarea name='content'></textarea><br>");
        out.print("취미: <input type='checkbox' name='hobby' value='취미1'>취미1 ");
        out.print("<input type='checkbox' name='hobby' value='취미2'>취미2");
        out.print("<input type='checkbox' name='hobby' value='취미3'>취미3");
        out.print("<input type='checkbox' name='hobby' value='취미4'>취미4");
        out.print("<input type='checkbox' name='hobby' value='취미5'>취미5<br>");
        out.print("<button type='submit'>작성하기</button>");
        out.print("</form>");
        System.out.println("BoardServlet do Get!!!");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //조회
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");
        String hobby = req.getParameter("hobby");

        System.out.printf("subject=%s, content=%s, hobby=%s\n",subject,content, hobby);
        //System.out.println("유입확인");

        String[] hobbies = req.getParameterValues("hobby"); //선택된 모든 데이터 보이게
        System.out.println(Arrays.toString(hobbies));
    }
}
