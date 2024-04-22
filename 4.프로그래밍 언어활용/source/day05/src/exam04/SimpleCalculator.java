package exam04;

public class SimpleCalculator extends Calculator{
    @Override
    public int add(int num1, int num2) {
        return num1+num2;
    }
    //기본생성자에 super호출되는중 -> calculator 기본생성자 불러올수있음


//    @Override
//    public void commonMethod() {
//
//    }
}
