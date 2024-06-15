<%@ page contentType="text/html; charset=utf-8" %>
<html>
<body>
<%
    response.setHeader("Cache-control", "use_cache");
    response.addHeader("contentType", "text/html; charset=utf-8");
    response.setDateHeader("date", 1L);
%>
Cache-control : <%=response.getHeader("Cache-control")%><br>
contentType : <%=response.getHeader("contentType")%><br>
date : <%=response.getHeader("date")%>
</body>
</html>