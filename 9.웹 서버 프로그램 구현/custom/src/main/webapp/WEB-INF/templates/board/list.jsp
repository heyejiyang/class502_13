<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<layout:main maintitle="게시글 목록">
    <h1>게시글 목록</h1>
    <ul>
        <c:forEach var="item" items="${items}" varStatus="status">
            <%--list에 items들을 하나씩 받아와서 item에 넣고 그 값을 이 안에서 사용--%>
            <li>
                    ${item.subject} / ${item.content} / ${item.poster} / ${item.regDt}
                    <%--EL식 사용할때 get 제거하고 속성명으로 접근가능--%>
                <div>
                    index: ${status.index} / count: ${status.count} /
                    first: ${status.first} / last: ${status.last} /
                    current: ${status.current}
                </div>
            </li>
        </c:forEach>
    </ul>
</layout:main>