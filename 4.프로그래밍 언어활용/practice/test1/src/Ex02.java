import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        int money = 16000;
        int cup = (money/5500);
        int change = money - cup * 5500;
        int[] answer = {cup, change};
        Arrays.stream(answer).forEach(System.out::println);
        System.out.println(15400 % 5500);
    }
}
