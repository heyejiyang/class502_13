<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<c:set var="date" value="<%=new Date()%>"/>


서울: <fmt:formatDate value="${date}" type="both" /><br>

<fmt:setTimeZone value="Europe/London"/><%--이 태그가 선언된 다음부터 계속 적용--%>
    런던: <fmt:formatDate value="${date}" type="both" /><br>


<fmt:setTimeZone value="America/NewYotk"/>
    뉴욕: <fmt:formatDate value="${date}" type="both" /><br>









