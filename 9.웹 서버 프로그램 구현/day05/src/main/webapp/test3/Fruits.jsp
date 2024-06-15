<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*" %>
<%
    ArrayList<String> items = new ArrayList<>();
    items.add("딸기");
    items.add("오렌지");
    items.add("복숭아");
    request.setAttribute("FRUITS", items);
    RequestDispatcher dispatcher = request.getRequestDispatcher("FruitsView.jsp");
    dispatcher.forward(request, response);
%>