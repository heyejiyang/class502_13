<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isErrorPage = "true" %>
<h1> 성뿡 등장</h1>
<%=exception.getMessage()%>

<%
    exception.printStackTrace();
%>