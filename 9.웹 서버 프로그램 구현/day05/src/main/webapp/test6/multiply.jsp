<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="num1" value="7"/>
<c:set var="num2" value="9"/>
<c:set var="result" value="${num1*num2}"/>

<html>
    <body>
        ${num1}과 ${num2}의 곱은? ${result}
    </body>
</html>