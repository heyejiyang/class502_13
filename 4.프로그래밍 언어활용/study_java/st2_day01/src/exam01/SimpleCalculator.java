package exam01;

public class SimpleCalculator extends Calculator{
//하위클래스에 메서드 재정의 하기

    @Override
    public int add(int num1, int num2) {
        return num1+num2;
    }

    @Override
    public int minus(int num1, int num2) {
        return num1-num2;
    }
//    public void commonMethod(){
//        //final예약어 메서드 재정의 불가능
//    }
}
