<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:forEach var="cnt" begin="1" end="10" step="2">
    <%--10번 반복, step 넣어주면 해당 숫자만큼 증가(1,3,5,7,9/10까지)--%>
    <div>
        ${cnt}호롤롤로
    </div>
</c:forEach>