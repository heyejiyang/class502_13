package ex04;

public class UserPwException extends RuntimeException{
    public UserPwException(String message){
        super(message); //상위 클래스 생성자 매개변수
    }
}
