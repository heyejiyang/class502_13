<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<ul>
    <c:forEach var="dish" items="${MENU}">
        <li>${dish}</li>
    </c:forEach>
</ul>
</body>
</html>