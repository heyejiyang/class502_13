<%@page contentType="text/html; charset=UTF-8" %>

<%--양식구성--%>
<form method="post" action="ex04_ps.jsp">
    작성자: <input type="text" name="poster"><br>
    제목: <input type="text" name="subject"><br>
    내용: <textarea name="content"></textarea><br>
    <button type="submit">작성하기</button>
</form>
<%--넘어간 값 setter을 통해서 넘어감--%>