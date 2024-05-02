package exam02;

import java.util.Arrays;
import java.util.List;

public class Ex11 {
    public static void main(String[] args) {
        List<Integer> scores = Arrays.asList(60, 78, 99, 67, 100);
        //정수 관련 특화 기능은 없다
        // 변환할수있는 메서드가 탑제되어있음
       long sum =  scores.stream().mapToInt(x -> x).sum();
        System.out.println(sum); //404
    }
}
