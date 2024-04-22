package exam03;

public class SimpleCalculator implements Calculator{

    @Override
    public int add(int num1, int num2) { //재정의시에도 public만 가능
        return num1+num2;
    }
}
