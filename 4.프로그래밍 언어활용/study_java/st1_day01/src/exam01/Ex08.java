package exam01;

import java.util.Arrays;

public class Ex08 {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6}};//선언과 동시에 초기화하기

        System.out.println(nums.length); //2행, 0번째, 1번째
        System.out.println(nums[0].length);//3열 (0,1,2)

        //중첩for문
        for(int i = 0; i< nums.length;i++){
            for(int j = 0; j< nums[i].length;j++) {
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }

        //Arrays.toString
        for(int i = 0; i< nums.length; i++){
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}
