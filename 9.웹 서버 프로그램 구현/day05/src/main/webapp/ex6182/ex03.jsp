<%@page contentType="text/html; charset=UTF-8" %>

<%--쿠키의 생명주기 설정--%>

<%
    Cookie cookie = new Cookie("key2","value1");
    cookie.setMaxAge(60 * 60 * 24 * 7); //일주일을 초단위로
    //쿠키 생명단위는 7일로줬음

    response.addCookie(cookie);
%>