package exam03;

import java.util.function.BiFunction;

public class Ex01 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> calc = (a, b) -> a + b;
        //Integer: 객체....
        //언박싱
        // 다시 오토박싱
        //다시 언박싱... 성능저하
        int result = calc.apply(10,20);
        System.out.println(result); //30
    }
}
