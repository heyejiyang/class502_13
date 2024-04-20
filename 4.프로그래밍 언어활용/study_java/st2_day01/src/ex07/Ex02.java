package ex07;

public class Ex02 {
    public static void main(String[] args) {
        int num3= 30;
        Calculator cal = new Calculator() {
            @Override
            public int add(int num1, int num2) {
                //num3 = 10; // 지역변수의 상수화, 변경 불가
                return num1 + num2 + num3;
            }
        };
        int result = cal.add(40,50);
        System.out.println(result);
    }
}
