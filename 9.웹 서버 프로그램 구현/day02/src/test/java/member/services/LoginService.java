package member.services;

import jakarta.servlet.http.HttpServletRequest;

public class LoginService {
    //HttpServletRequest 인터페이스: 사용자 요청 데이터 조회, 처리
    public void process(HttpServletRequest request){//사용자가 입력한 데이터 조회할 수 있는 객체 넘겨줌
        //아이디: email, 비밀번호: password
        String email = request.getParameter("email");//사용자가 입력한 값 확인할 수 있는 메서드
        String password = request.getParameter("password");

        System.out.printf("email=%s, password=%s%n", email,password); //값 확인해보기 테스트
    }
}
