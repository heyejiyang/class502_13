package Exam01;

public class Ex01 {
    public static void main(String[] args) {
        // %d(정수), %f(실수), %s(문자열), %c(문자)

        /*
        * %자리수s -> %5s    공백3ab   -> 왼쪽 공백
        * %-자리수s  -> %-5s ab공백3   -> 오른쪽 공백
        *
        * */

        int ab = 12345;

        System.out.printf("%-10d",ab); //오른쪽 공백
        System.out.println("--");
        System.out.printf("%10d\n",ab); //왼쪽 공백
        System.out.printf("%09d\n",ab); //0으로 공백 채우기

        double num = 123456.123456;
        System.out.printf("%f\n", num);
        System.out.printf("%.2f\n", num);
        System.out.printf("%010.2f\n",num); // 0으로공백 채우기


    }
}
