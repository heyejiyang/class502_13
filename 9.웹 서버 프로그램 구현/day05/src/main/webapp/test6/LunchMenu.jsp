<%@page contentType="text/html; charset=utf-8"%>
<%
    String[] arr = { "불고기 백반", "오므라이스", "콩국수" };
    request.setAttribute("MENU", arr);
%>
<jsp:forward page="LunchMenuView.jsp" />