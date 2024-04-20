package exam01;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex06 {

    static String str;
    public static void main(String[] args) {
        System.out.println(str); //null

        String[] strs = new String[4];
        System.out.println(Arrays.toString(strs));
        //기본값 null

        int[] nums = {10,20,30,40};
        for(int num: nums){ //향상된 for문
            System.out.println(num);
        }

        //String에선 한줄로 가능
       // IntStream.range(0,nums.length).forEach(i -> System.out.println(nums[i]));
    }
}
/*
* 자료형
* - 기본 자료형: 숫자를 담는 변수의 크기
* - 참조 자료형: 주소값을 담는 변수의 자료형 -> 기본값 null
* */