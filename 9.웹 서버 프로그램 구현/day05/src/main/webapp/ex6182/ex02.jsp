<%@page contentType="text/html; charset=UTF-8" %>

<%
    //쿠키 배열형태로 가져옴
    Cookie[] cookies = request.getCookies(); //개별조회는 없음

    for(Cookie cookie : cookies){
        String name = cookie.getName(); //쿠키 이름 가져오기
        String value = cookie.getValue(); //값 확인

        //콘솔출력
        System.out.printf("name=%s, value=%s\n",name,value);
    }
%>