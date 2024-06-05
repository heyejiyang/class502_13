package global.validators;

public interface RequiredValidator {
    default void checkRequired(String field,RuntimeException e){
        //다양한 상황의 예외 대응하기 위해 다형성 이용, 검증 예외로 고정 x
        if(field == null || field.isBlank()){
            throw e;
        }
    }
}
