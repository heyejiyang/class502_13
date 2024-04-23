package ex04;

public class UserIdException extends RuntimeException{

    public UserIdException(String message){
        super(message); //상위 클래스 생성자 매개변수
    }
}
