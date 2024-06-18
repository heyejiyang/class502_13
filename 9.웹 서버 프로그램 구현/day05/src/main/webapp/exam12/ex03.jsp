<%@page contentType="text/html; charset=UTF-8" %>

<%
    //세션 삭제
    //session.removeAttribute("title");

    //세션 싹 비우기
    session.invalidate();
%>