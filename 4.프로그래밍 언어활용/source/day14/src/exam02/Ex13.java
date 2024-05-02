package exam02;

import java.util.stream.IntStream;

public class Ex13 {
    public static void main(String[] args) {
        //for문 대신 간편히 가능
        IntStream.range(0,10).forEach(i -> System.out.println("반복"+i));
    }
}
