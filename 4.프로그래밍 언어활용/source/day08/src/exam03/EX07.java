package exam03;

public class EX07 {
    public static void main(String[] args) {
        double result = add(10.0, 10L);
        System.out.println(result);
    }
    //매개변수값이 int인지 long인지 뭔지 명확히 자료형을 알수없을때 Number로 대체해서 쓴다.
    //반환값도 마찬가지!
    public static double add(Number num1, Number num2){
        return num1.doubleValue() + num2.doubleValue();
    }
}
