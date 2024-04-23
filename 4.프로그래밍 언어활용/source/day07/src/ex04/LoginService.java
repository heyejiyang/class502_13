package ex04;

public class LoginService {
    public void login(String userId, String userPw) throws UserIdException, UserPwException {
        //userId - user01, userPw = 1234

            if (!userId.equals("user01")) {
                //아이디가 아니면
                throw new UserIdException("아이디가 일치하지 않습니다.");
                //Exception을 바로 상속받은 예외 클래스 -> 컴파일도x -> 예외가 발생하든 안하든 반드시 적절한 예외처리가 필요한 예외이다 - 엄격한 예외
            }

            if (!userPw.equals("1234")) {
                throw new UserPwException("비밀번호가 일치하지 않습니다.");
            }

    }
}
