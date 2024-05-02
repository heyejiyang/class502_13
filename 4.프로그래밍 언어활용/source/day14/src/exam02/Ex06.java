package exam02;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class Ex06 {
    public static void main(String[] args) {
        int[] nums = {10,20,30,40,50};
        int[] nums2 = map(nums, x -> x * x);
        System.out.println(Arrays.toString(nums2));
    }
    public static int[] map(int[] nums, IntUnaryOperator oper){ //함수형 인터페이스
        int[] newsNums = new int[nums.length];
        for(int i = 0; i< nums.length; i++){ //내부에서 반복
            newsNums[i] = oper.applyAsInt(nums[i]);  //함수 호출
        }
        return newsNums; // 값 넘겨주기
    }
    //map 처럼 변환작업을쓸때에는 function인터페이스를 사용한다.
}
