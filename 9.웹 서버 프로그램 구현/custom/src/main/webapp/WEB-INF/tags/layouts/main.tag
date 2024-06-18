<%@tag body-content="scriptless"
       pageEncoding="UTF-8"
       trimDirectiveWhitespaces="true" %>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="cssUrl" value="/static/css/"/>
<c:url var="jsUrl" value="/static/js/"/>

<%@attribute name="maintitle"%>

<layout:common title="${maintitle}">
    <jsp:attribute name="header">
        <h1>메인 레이아웃 상단 영역</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <h1>메인 레이아웃 하단 영역</h1>
    </jsp:attribute>
    <jsp:attribute name="commonCss">
        <link rel="stylesheet" type="text/css" href="${cssUrl}main.css">
    </jsp:attribute>
    <jsp:attribute name="commonJs">
        <script src="${jsUrl}main.js"></script>
    </jsp:attribute>

    <jsp:body>
        <jsp:doBody/>
    </jsp:body>
</layout:common>