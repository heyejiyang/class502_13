<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:catch var="e">
<%
    String str = null; //nullPointException발생시키잣
    str.toUpperCase();
%>
</c:catch>
<c:if test="${e != null}">
    <%--에러가 발생했을 경우 e 는 null 아님, 에러 없을 경우 e = null --%>
    에러 메시지 : ${e.message} <%--EL식 get(getMessage())제외 후 속성명으로 접근 가능--%>
</c:if>