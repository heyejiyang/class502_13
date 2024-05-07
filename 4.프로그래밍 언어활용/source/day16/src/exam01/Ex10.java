package exam01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex10 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("이름1", "이름2", "이름3");
        List<String> fruits = Arrays.asList("Apple", "Orange", "Melon");

        Stream<Stream<String>> stm = Stream.of(names.stream(), fruits.stream());

        //stm.forEach(System.out::println);
        //스트림 객체 반환
        //java.util.stream.ReferencePipeline$Head@6d311334
        //java.util.stream.ReferencePipeline$Head@682a0b20

       /* stm.forEach(st -> {
            st.forEach(System.out::println);
        });*/

        //스트림 중첩된구조
        //1차원적인 스트림으로 평탄화작업하기
        //stm.flatMap(s -> s).forEach(System.out::println);

        String[] strs = stm.flatMap(s -> s).toArray(String[]::new);
        System.out.println(Arrays.toString(strs));
        //[이름1, 이름2, 이름3, Apple, Orange, Melon]

    }
}
