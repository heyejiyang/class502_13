package exam01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ex08 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        //가변적 형태 매개변수임
        Collections.addAll(names,"이름1","이름2","이름3");
        System.out.println(names);//[이름1, 이름2, 이름3]
    }
}
