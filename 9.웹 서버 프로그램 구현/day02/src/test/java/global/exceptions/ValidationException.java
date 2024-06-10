package global.exceptions;

public class ValidationException extends RuntimeException{
    public ValidationException(String message){
        super(message); //메시지 - 상위 RuntimeException에서 처리
    }

}
