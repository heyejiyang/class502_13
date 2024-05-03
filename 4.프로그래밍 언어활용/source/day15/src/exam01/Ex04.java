package exam01;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex04 {
    public static void main(String[] args) {
        int[] nums = IntStream.iterate(2, x -> x + 2).limit(10).toArray();
        System.out.println(Arrays.toString(nums));
        //[2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
    }
}
