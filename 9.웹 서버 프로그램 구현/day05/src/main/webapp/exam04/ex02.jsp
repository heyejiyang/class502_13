<%@ page contentType="text/html; charset=UTF-8" %>

<%
    application.setAttribute("num",100);
    request.setAttribute("num",200);
    //동일한 명칭의 속성을 사용하게 될 경우 범위가 좁은것이 출력된다.
    pageContext.setAttribute("num",300);

    pageContext.setAttribute("max-num",1000);
%>

<%--요청범위에 있는 속성 바로 접근하기--%>
pageContext.num : ${pageScope.num}<br>
request.num : ${requestScope.num}<br>
application.num : ${applicationScope['num']}<br>

max-num: ${pageScope['max-num']}<br>