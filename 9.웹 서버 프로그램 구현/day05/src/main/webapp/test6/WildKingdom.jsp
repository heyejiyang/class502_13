<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:set var="guests" value="토끼^^거북이~사슴" />
<c:forTokens var="animal" items="${guests}" delims="^~">
    ${animal} <br>
</c:forTokens>
</body>
</html>