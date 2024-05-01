package exam01;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        int[][] nums1 = {{10,20,30},{40,50,60}};

        System.out.println(Arrays.toString(nums1));
        //[[I@4eec7777, [I@3b07d329] 주소 출력

        System.out.println(Arrays.deepToString(nums1));
        //[[10, 20, 30], [40, 50, 60]]
    }
}
