package exam01;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public class Ex06 {
    public static void main(String[] args) {
        ToIntFunction<String> func1 = s -> s.length();//int가 반환값
        //s 가 String이라는거 알고있다. s 생략

        ToIntFunction<String> func2 = String::length;

        BiPredicate<String,String> cond1 = (s1,s2) -> s1.equals(s2);//매개변수2개, 반환값 boolean
        //매개변수 형태 정해져있고,투입된 순서와 순서도 바뀌지 않고(s1 -> s2) .. 생략
        BiPredicate<String,String> cond2 = String::equals;

    }
}
