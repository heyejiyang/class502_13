<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="html" value="<script>alert('알림!');</script>"/>

<c:out value="${html}"/> <%--스크립트가 실행이 안되고 태그자체가 문자열로 바뀌어있다.--%>

<c:out value="${str}" default="값 없을때 대체되는값"/><br>
<c:out value="<h1>제목</h1>" escapeXml="false" />