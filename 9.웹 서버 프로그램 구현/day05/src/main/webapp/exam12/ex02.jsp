<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="board.entities.*"%>

<%
    BoardData board = BoardData.builder()
            .subject("제목")
            .content("내용")
            .build();

    session.setAttribute("board",board);
    session.setAttribute("title","제목"); //문자열데이터도 저장 가능
%>


