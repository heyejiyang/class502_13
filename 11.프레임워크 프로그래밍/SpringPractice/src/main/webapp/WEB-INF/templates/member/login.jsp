<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:url var="actionUrl" value=""/>

<h1><spring:message code="로그인"/></h1>
<form:form method="POST" action="${actionUrl}" autocomplete="off" modelAttribute="requestLogin">
    <dl>
        <dt><spring:message code="이메일"/></dt>
        <dd>
            <form:input path="email"/>
            <form:errors path="email" cssClass="error-txt"
                         cssStyle="color: red"/>
                <%-- errors에 에러가 있으면 출력 없으면 출력되지 않음, 에러 여러개 있으면 여러개 출력--%>
        </dd>
    </dl>
    <dl>
        <dt><spring:message code="비밀번호"/></dt>
        <dd>
            <form:password path="password"/>
            <form:errors path="password" cssClass="error-txt"
                         cssStyle="color: red" />
        </dd>
    </dl>
    <dl>
        <dd>
            <form:checkbox path="saveEmail" value="true" label="이메일 저장하기"/>
        </dd>
    </dl>
    <form:errors element="div" delimiter=""/>
    <button type="submit">
        <spring:message code="로그인하기"/>
    </button>
</form:form>