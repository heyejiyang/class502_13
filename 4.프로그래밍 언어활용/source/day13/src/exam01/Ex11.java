package exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex11 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");

        Collections.swap(names,1,4); //1번 인덱스와 4번 인덱스 값 교체
        System.out.println(names);//[이름1, 이름5, 이름3, 이름4, 이름2]
    }
}
