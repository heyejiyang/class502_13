<%@ page contentType="text/html; charset=UTF-8" %>
<h1>게시글 작성</h1>
<form method="post" action="post_ps.jsp">
    제목: <input type="text" name = 'subject'><br>
    내용: <textarea name = "content"></textarea><br>
    <button type='submit'>작성하기</button>
</form>

<%
//메서드 지역 안에서 번역
    int num1 = 100;
    int num2 = 200;
    //int result = num1 + num2;
    int result = add(num1,num2);
    System.out.println(result);
%>

<%! //번역객체가 서로 다른 위치에 있기 때문에 같은 변수가 선언되도 오류 발생하지 않는다.
// 클래스 안 멤버변수 멤버메서드로 번역
    int num1 = 10;
    int num2 = 20;
    int add(int num1, int num2){
        return num1+num2;
    }
%>