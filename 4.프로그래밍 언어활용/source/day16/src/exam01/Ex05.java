package exam01;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex05 {
    public static void main(String[] args) {
        String[] names = {"이름1", "이름2","이름2","이름3","이름4","이름5"};
        Set<String> namesSet = Arrays.stream(names).collect(Collectors.toSet());
        // 중복제거, 집합형태로 변환
        System.out.println(namesSet); //[이름3, 이름2, 이름1, 이름5, 이름4]
    }
}
