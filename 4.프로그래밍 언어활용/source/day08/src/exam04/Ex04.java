package exam04;

import java.util.Arrays;
import java.util.Objects;

public class Ex04 {
    public static void main(String[] args) {
//        String str = null;
//        str = Objects.requireNonNullElse(str,"");//null 일때 기본값 넣어주기
//        str.toUpperCase(); //nullPointerException 발생, NPE ㅠㅠ

        int[] nums1 = {10,20,30,40};
        int[] nums2 = {10,20,30,40};
        boolean isSame = Arrays.equals(nums1,nums2);
        System.out.println(isSame);

        int[][] nums3 = {{10,20,30},{40,50,60}};
        int[][] nums4 = {{10,20,30},{40,50,60}};
        boolean isSame2 = Arrays.deepEquals(nums3,nums4);
        System.out.println(isSame2);
         //배열이 동일한가 비교

       /*boolean isSame = true;
        for(int i = 0; i< nums1.length;i++){
            if(nums1[i] != nums2[i]){
                isSame = false;
                break;
            }
        }
        System.out.println(isSame);*/


    }
}
