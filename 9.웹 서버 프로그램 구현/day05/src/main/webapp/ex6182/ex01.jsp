<%@page contentType="text/html; charset=UTF-8" %>
<%
    //response내장객체로 쿠키 등록
    Cookie cookie1 = new Cookie("key1","value1");
    response.addCookie(cookie1);

%>