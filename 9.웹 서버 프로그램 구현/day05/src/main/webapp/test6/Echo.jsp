<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:forEach var="cnt" begin="1" end="5">
    <font size=${cnt}>야~호~</font> <br>
</c:forEach>
</body>
</html>

<c:forEach var="str" items="${arr}">
    ${str} <br>
</c:forEach>