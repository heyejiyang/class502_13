package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Transportation BUS = Transportation.BUS;
        //내부적으로 정적 상수형태로 만들어져있다.
        System.out.println(BUS instanceof Transportation);//true
    }
}
