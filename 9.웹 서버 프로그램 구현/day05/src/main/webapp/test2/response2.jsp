<%@ page contentType="text/html; charset=utf-8" %>
<html>
<body>
이 페이지는 5초마다 새로고침 됩니다.<br>
<%
    response.setIntHeader("Refresh", 5);
%>
<%=java.util.Calendar.getInstance().getTime()%>
</body>
</html>