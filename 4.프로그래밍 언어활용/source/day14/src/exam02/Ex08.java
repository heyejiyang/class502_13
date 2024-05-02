package exam02;

import java.util.Arrays;

public class Ex08 {
    public static void main(String[] args) {
        int[] nums = {22,11,10,2,6,8,33};
        Arrays.stream(nums)
                .map(x -> x * x)
                .filter(x -> x % 2 == 1)
                .forEach(System.out::println);
        //map과 filter는 중간 연산
        //forEach를 해줘야 출력, forEach는 최종 연산
    }
}
