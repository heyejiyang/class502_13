package exam03;

public class EX03 {
    public static void main(String[] args) {
        Integer num1 = Integer.valueOf(10);
        Integer num2 = Integer.valueOf(10);
        System.out.println(System.identityHashCode(num1));
        System.out.println(System.identityHashCode(num2));
        //1324119927
        //1324119927
    }
}
