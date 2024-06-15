<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
    <h3>
        this is first.jsp
    </h3>
<%--    <jsp:forward page="second.jsp"/>--%>
    <jsp:include page="second.jsp">
        <jsp:param name="date" value="<%=java.util.Calendar.getInstance().getTime()%>"/>
    </jsp:include>
</body>
</html>