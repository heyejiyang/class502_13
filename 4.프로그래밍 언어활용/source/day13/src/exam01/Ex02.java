package exam01;

import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        int[] nums1 = {10,20,30,40,50,60};
        int[] nums2 = Arrays.copyOf(nums1,3);
        System.out.println(nums1); //주소값 출력됨.
        System.out.println(Arrays.toString(nums1)); //배열 값 출력

        System.out.println(Arrays.toString(nums2)); //복사된 배열 값 출력
        //[10, 20, 30]

        int[] nums3 = Arrays.copyOfRange(nums1,1,5);//index 0번부터 시작 1 ~ 5번 미만 까지 복사

        System.out.println(Arrays.toString(nums3));//[20, 30, 40, 50]
    }
}
