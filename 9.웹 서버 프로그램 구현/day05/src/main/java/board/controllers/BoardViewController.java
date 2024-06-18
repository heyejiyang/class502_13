package board.controllers;

import board.entities.BoardData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {
    //요청메서드

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //jsp는 내장객체로 세션 객체가 존재, 현재 request, response객체가 존재하는데 여기서 request는 session을 가져올 수 있다.

        HttpSession session = req.getSession();
        BoardData board = (BoardData) session.getAttribute("board"); //EL식 속성으로 바로 접근이 가능하다.
        String title = (String)session.getAttribute("title");

        System.out.println(board);
        System.out.println(title);
    }
}
