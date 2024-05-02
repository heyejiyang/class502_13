package exam01;

import java.util.Arrays;
import java.util.List;

public class Ex08 {
    public static void main(String[] args) {
        List<String> alpha = Arrays.asList("abc","def","ghi");

        String[] upperAlpha = alpha.stream().map(String::toUpperCase).toArray(i -> new String[i]);

        System.out.println(Arrays.toString(upperAlpha)); //[ABC, DEF, GHI]

        String[] upperAlpha2 = alpha.stream().map(String::toUpperCase).toArray(String[]::new);
        System.out.println(Arrays.toString(upperAlpha2)); //[ABC, DEF, GHI]
    }
}
