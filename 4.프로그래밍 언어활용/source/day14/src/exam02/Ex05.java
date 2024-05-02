package exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex05 {
    public static void main(String[] args) {
        int[] nums = {22, 11, 15, 35, 40, 77};

        IntStream stm = Arrays.stream(nums); //스트림은 1회용 객체이다.
        int total = stm.map(x -> x * x).sum(); //제곱한 다음에 더함
        System.out.println(total); //9584

        IntStream stm2 = Arrays.stream(nums); //객체를 새로 만들어야 사용 가능
        int total2 = stm2.map(x -> x * x * x).sum();
        //스트림은 1회용 객체이기 때문에 재사용이 불가능하다.
        //System.out.println(total2); // 오류 stream has already been operated upon or closed
        System.out.println(total2); //578762
    }
}
