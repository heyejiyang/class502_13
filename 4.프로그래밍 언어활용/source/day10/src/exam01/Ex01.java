package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Transportation trans1 = Transportation.BUS; //상수형태라 Transportation으로 직접 접근
        Transportation trans2 = Transportation.SUBWAY;
        Transportation trans3 = Transportation.TAXI;
        System.out.println(trans1 == trans2); //true
    }
}
