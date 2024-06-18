<%@ page contentType="text/html; charset=UTF-8"%>

<%
    Cookie cookie = new Cookie("memberId","admin");
    response.addCookie(cookie);
%>