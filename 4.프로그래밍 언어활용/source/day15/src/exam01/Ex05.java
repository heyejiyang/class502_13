package exam01;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex05 {
    public static void main(String[] args) {
        int[] nums = IntStream.generate(() -> 1).limit(10).toArray();//숫자1로 채운 형태의 배열

        System.out.println(Arrays.toString(nums));
        //[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
    }
}
