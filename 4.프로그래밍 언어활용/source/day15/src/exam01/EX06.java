package exam01;

import java.util.Arrays;
import java.util.stream.IntStream;

public class EX06 {
    public static void main(String[] args) {
        IntStream stm1 = IntStream.rangeClosed(1,50);
        IntStream stm2 = IntStream.rangeClosed(51,100); //두개의 스트림을 결합시키자 1 ~ 100

        //하나의 스트림으로 통합
        IntStream stm = IntStream.concat(stm1,stm2); // 1 ~ 100
        int[] nums = stm.toArray(); //배열에 담자
        System.out.println(Arrays.toString(nums));
        //[1, 2, 3, 4, 5, 6, ....,99, 100]
    }
}
