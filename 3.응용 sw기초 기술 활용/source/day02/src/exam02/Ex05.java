package exam02;

import java.util.Arrays;

public class Ex05 {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6}};
//        System.out.println(nums.length);
//        System.out.println(nums[0].length);
//
//        for(int i=0; i<nums.length;i++){
//            for(int j=0;j<nums[i].length;j++){
//                System.out.print(nums[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.deepToString(nums));
    }


}
