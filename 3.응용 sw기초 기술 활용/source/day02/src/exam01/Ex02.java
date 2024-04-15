package exam01;

public class Ex02 {
    public static void main(String[] args) {
        int num = 10;
        boolean result = num++ > 10 && (num = num + 10)>15;
        System.out.println(result); //false
        System.out.println(num);//11
    }
}
