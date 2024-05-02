package exam01;

import java.util.function.Function;

public class Ex04 {
    public static void main(String[] args) {
        Function<String,Integer> func1 = s -> s.length();
        //int len = func1.apply("가나다");
        //System.out.println(len); //3

        //두수를 제곱하는 형태의 함수
        Function<Integer,Integer> func2 = x -> x * x;

        //함수의 합성
        Function<String,Integer> func3 = func1.andThen(func2);
        Function<String,Integer> func4 = func2.compose(func1); //동작 동일

        int num = func4.apply("가나다"); // 가나다 -> 3 -> 제곱 -> 9
        System.out.println(num); //9
    }
}
