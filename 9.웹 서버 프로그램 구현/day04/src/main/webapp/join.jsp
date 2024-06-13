<%@ page contentType="text/html; charset=UTF-8" %>

<% //지역내부
    int num1 = 100;
    int num2 = 200;
    int result = num1+num2;
    out.write("result = " + result);
    out.write("<br>이름:" + name);
%>
<br>

<%-- jsp주석.. 번역 배제--%>
<%--
<%=num1%> + <%=num2%> = <%=result%>
--%>

<%! //선언문
    String name ="홍길동";
%>