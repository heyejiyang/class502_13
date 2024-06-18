<%@tag body-content="scriptless"
       pageEncoding="UTF-8"
       trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ attribute name="header" fragment="true" %> <%--치환할 수 있는 부분 영역--%>
<%@ attribute name="footer" fragment="true" %>

<c:url  var="cssUrl" value="/static/css/"/>
<c:url var="jsUrl" value="/static/js/"/>

<%--공통적인 레이아웃 구성--%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>레이아웃 연습!</title>
        <link rel="stylesheet" type="text/css" href="${cssUrl}style.css">
        <c:if test="${addCss != null}">
            <c:forEach var="cssFile" items="${addCss}">
                <link rel="stylesheet" type="text/css" href="${cssUrl}${cssFile}.css">
            </c:forEach>
        </c:if>
        <script src="${jsUrl}common.js"></script>
        <c:if test="${addScript != null}">
            <c:forEach var="jsFile" items="${addScript}">
                <script src="${jsUrl}${jsFile}.js"></script>
            </c:forEach>
        </c:if>
    </head>
    <body>
        <header>
            <jsp:invoke fragment="header"/> <%--대체 내용물이 여기로 교체가 된다.--%>
<%--            <h1>사이트 상단 영역</h1>--%>
        </header>
        <main>
            <jsp:doBody/> <%--태그 안쪽에 있는 내용으로 교체--%>
        </main>
        <footer>
            <jsp:invoke fragment="footer"/>
<%--            <h1>사이트 하단 영역</h1>--%>
        </footer>
    </body>
</html>