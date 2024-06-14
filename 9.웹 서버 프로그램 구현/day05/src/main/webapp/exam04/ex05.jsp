<%@ page contentType="text/html; charset=UTF-8" %>
User-Agent: ${header['User-Agent']}<br>

JSESSIONID: ${cookie.JSESSIONID.getValue()}<br>
JSESSIONID: ${cookie.JSESSIONID.value}<br> <%--get제외하고 불러도 호출 됨--%>
key1: ${initParam.key1}<br>


URI: ${pageContext.request.requestURI}<br>
<%-- El식 사용하면 getRequest(), getRequestURI() get제외하고 속성 이름 형태로불러도 호출 됨--%>