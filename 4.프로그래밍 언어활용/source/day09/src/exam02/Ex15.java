package exam02;

import java.util.Arrays;

public class Ex15 {
    public static void main(String[] args) {
        String str = "Apple Mango Melon     Banana";
        String[] fruits = str.split(" ");
        System.out.println(Arrays.toString(fruits)); //공백까지 쪼개짐

        String[] fruits2 = str.split("\\s+");//1개이상의 공백
        System.out.println(Arrays.toString(fruits2));
    }
}
