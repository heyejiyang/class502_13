package exam02;

import java.util.Arrays;
import java.util.Comparator;

public class Ex12 {
    public static void main(String[] args) {
        int[] nums = {33,10,5,1,3,88,100,10};
        int[] nums2 = Arrays.stream(nums).sorted().toArray(); //toArray 최종연산

        System.out.println(Arrays.toString(nums2)); //오름차순
        //[1, 3, 5, 10, 10, 33, 88, 100]

        int[] nums3 = Arrays.stream(nums).boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(x -> x).toArray();
        System.out.println(Arrays.toString(nums3)); //내림차순
        //[100, 88, 33, 10, 10, 5, 3, 1]
    }
}
