<%@page contentType="text/html; charset=UTF-8" %>
<%@ page import="board.entities.BoardData" %>

<jsp:useBean id="item" class="board.entities.BoardData" scope="request" />
<jsp:setProperty name="item" property="*"/><%--모든 프로퍼티--%>
<%--<jsp:setProperty name="item" property="subject"/>--%>
<%--<jsp:setProperty name="item" property="content"/>--%>
<%--<jsp:setProperty name="item" property="poster" param="writer"/>--%>

제목: ${item.subject}<br>
내용: ${item.content}<br>
작성자: ${item.poster}<br>