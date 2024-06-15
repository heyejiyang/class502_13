<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*" %>
<%
    HashMap<String, String> map = new HashMap<>();
    map.put("Edgar", "보스턴");
    map.put("Thomas", "오하이오");
    map.put("John", "워싱턴");
    request.setAttribute("ADDRESS", map);
%>