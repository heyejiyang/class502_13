package exam01;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9,11,13};
        //boolean isOdd = Arrays.stream(nums).allMatch(x -> x % 2 == 1); //모든 값이 참이여야 true
       // System.out.println(isOdd); //true
        //boolean isEven = Arrays.stream(nums).anyMatch(x -> x % 2 == 0); //하나라도 참이면 true
        //System.out.println(isEven);// true
        boolean notIncludedEven = Arrays.stream(nums).noneMatch(x -> x % 2 == 0); //전부 거짓일때 참
        System.out.println(notIncludedEven); //false
    }
}
