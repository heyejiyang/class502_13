<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--<h1>ex04.jsp - 상단</h1>--%>
<%--<c:import var="html" url="inc.jsp"/> &lt;%&ndash;출력되지 않고 html변수에 담겨있다.&ndash;%&gt;--%>
<%--&lt;%&ndash;위처럼만 작성시 inc.jsp내용 출력되지 않음&ndash;%&gt;--%>

<%--${html}--%>
<%--${html}--%>
<%--<h1>ex04.jsp -하단</h1>--%>
<h1>ex04.jsp - 상단</h1>

<c:import url="inc.jsp">
    <c:param name="num1" value="100"/>
    <c:param name="num2" value="200"/>
</c:import>

<h1>ex04.jsp -하단</h1>