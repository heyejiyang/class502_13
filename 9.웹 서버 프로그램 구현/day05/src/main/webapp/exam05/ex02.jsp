<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="num1" value="100"/><%--기본값 page--%>
<c:set var="num1" value="200" scope="request"/>
<c:set var="num1" value="300" scope="application"/>

<%--<c:remove var="num1"/>--%>
<%--스코프를 설정하지 않으면 전체 모든 범위의 속성을 제거한다.--%>

<c:remove var="num1" scope="request"/> <%--request범위 속성 제거--%>

pageScope.num1 : ${pageScope.num1}<br>
requestScope.num1 : ${requestScope.num1}<br>
applicationScope.num1: ${applicationScope.num1}<br>