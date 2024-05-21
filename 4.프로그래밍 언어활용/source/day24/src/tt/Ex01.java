package tt;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int[] array = {7, 77, 17};
        String str = Arrays.toString(array);
        int count = (int)str.chars().filter(i -> i == '7').count();

        System.out.println(count);
    }
}
