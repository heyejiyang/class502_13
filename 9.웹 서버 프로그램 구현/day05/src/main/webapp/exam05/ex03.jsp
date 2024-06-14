<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="num" value="10"/><%--홀수--%>
<c:if test="${num %2 == 1}"><%--짝수일때 값이 나오지 않음, else존재 x--%>
    홀수 입니다.
</c:if>
<c:if test="${num %2 == 0}"><%--짝수일때 if문 반대로 또 쓰면 됨--%>
    짝수 입니다.
</c:if>
<br>
${num % 2 == 1 ? '홀수 입니다.':'짝수 입니다.'}