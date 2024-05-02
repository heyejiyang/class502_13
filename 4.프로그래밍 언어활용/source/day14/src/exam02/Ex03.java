package exam02;

import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        /*
        * 1. 문자열 앞뒤로 * ... *
        * 2. 대문자 변환
        * 3. 출력
        * */
        String[] fruits = {"apple","orange","mango","melon"};
       // Arrays.stream(fruits)
        // .map(s -> "*" + s + "*")
        // .map(s -> s.toUpperCase())
        // .forEach(s -> System.out.println(s)); //메서드 체인 방식사용

        // 좀 더 짧은 방식으로
        Arrays.stream(fruits).map(s -> "*" + s + "*")
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
    /*
    * *APPLE*
     *ORANGE*
     *MANGO*
     *MELON*
     * */
}
