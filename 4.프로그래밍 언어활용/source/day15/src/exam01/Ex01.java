package exam01;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        String[] fruits = {"apple","Orange","apple","banana","Melon","Mango"};

        /**
         * 1. 중복제거
         * 2. 문자열 길이 변경 (String -> int: mapToInt) mapToInt: String에서 int로 문자열 길이를 가지고 바꿔줌
         * 3. int[] 배열로 변경
         */

        int[] nums = Arrays
                .stream(fruits)
                .distinct()
                .mapToInt(String::length)
                .toArray();
        System.out.println(Arrays.toString(nums)); //문자열길이 배열로 바꿔서 출력
    }
}
