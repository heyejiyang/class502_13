package exam02;

public interface Calculator {
    /*
    * 컴파일러는 interface의 내용은 모두 추상메서드라고 인식하고있다.
    * 인터페이스의 목적은 설계/추상메서드만 정의하는것이라 컴파일러에서 public abstract를 자동추가 해준다. 그래서 쓰지 않아도 오류발생하지않음
    * 하지만 public일때만 가능, 다른 접근제어자 사용 불가
    * */
    int add(int num1, int num2);
}
