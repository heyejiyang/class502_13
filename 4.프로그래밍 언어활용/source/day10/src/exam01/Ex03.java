package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Transportation BUS = Transportation.BUS;
        Enum trans = BUS; //모든 상수가 transportation 객체이고 Enum상수는 java.lang.Enum의 하위 클래스로 되어있다 -> 다형성 o
        //내부적으로 정적 상수형태로 만들어져있다.
        System.out.println(BUS instanceof Transportation);//true
    }
}
