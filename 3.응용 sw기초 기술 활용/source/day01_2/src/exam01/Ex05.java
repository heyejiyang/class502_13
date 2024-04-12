package exam01;

public class Ex05 {
    public static void main(String[] args) {
        int num1 = 10;
        num1 = 20;
        final int num2 = 30;//변경불가 - 상수
        //num2 = 10; //변경시도 할시에 오류
        System.out.println(num1);

        //상수는 대문자로 변수 작성할 것 !! 관례
        final int NUM3 = 5;
        System.out.println(NUM3);
    }
}
