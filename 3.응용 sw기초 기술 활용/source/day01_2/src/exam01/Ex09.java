package exam01;

public class Ex09 {
    public static void main(String[] args) {
        long num1 = 100000000000L;
        double num2 = num1;
        float num3 = num1;

        double num4 = 0.0;
        for(int i = 0; i< 1000; i++){
            num4 += 0.1;
        }
        System.out.println(num4);
    }//표현 범위 자체는 가능할지 몰라도 정밀도는 떨어질수있다.
}
