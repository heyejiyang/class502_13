<%@ tag import="java.util.Map" %>
<%@ tag body-content="empty" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ tag dynamic-attributes="attrs" %>
<%--color: ${attrs.color}<br>--%>
<%--size: ${attrs.size}<br>--%>

<%
    Map<String, String> attrs = (Map<String, String>)jspContext.getAttribute("attrs");
    String _size = attrs.getOrDefault("size","0"); //값이 없을때 기본값
    int size = Integer.parseInt(_size);
%>

<div style="color: ${attrs.color}">
    <%
        for(int i = 0; i<size;i++){
            out.write("⭐");
        }
    %>
</div>