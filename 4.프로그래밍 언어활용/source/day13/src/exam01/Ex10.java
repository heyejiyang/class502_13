package exam01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex10 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("이름1","이름2","이름3","이름4","이름5");

        String max = Collections.max(names);
        System.out.println(max);//이름5
        String min = Collections.min(names);
        System.out.println(min); //이름1

        Collections.shuffle(names);// 무작위로 값 섞기
        System.out.println(names);
        String max2 = Collections.max(names);
        System.out.println(max2);//이름5
        String min2 = Collections.min(names);
        System.out.println(min2); //이름1

    }
}
