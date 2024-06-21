<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:url var="actionUrl" value="/file/upload"/>

<form method="post" action="${actionUrl}" enctype="multipart/form-data">
<%-- 게시글 제목 내용 파일 올리기  --%>
    제목: <input type="text" name="subject"><br>
    내용: <input type="text" name="content"><br>
    파일: <input type="file" name="file"><br>
    <button type="submit">작성하기</button>
</form>