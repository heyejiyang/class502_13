package global.validators;

public interface Validator<T> {
    //다앙한 형태의 자료형 지네릭스
    void check(T form);
}
