package ex04;

public class Ex01 {
    public static void main(String[] args) {
        LoginService log = new LoginService();
        try {
            log.login("useuse","1234");
        }catch (Exception e){//UserIdException|UserPwException e 처리 동일 -> 다형성 적용
            System.out.println(e.getMessage());
        }
    }
}
