package exam01;

import java.util.Arrays;
import java.util.List;

public class Ex07 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("사과","배","오렌지","포도","멜론","망고");

        //2개 건너뛰고 2가지 가져오기
        String[] selected = fruits.stream()
                .peek(System.out::println) //확인의 용도(훔쳐보기~!) //메서드 참조
                .skip(2)
                .limit(2)
                //.toArray(i -> new String[i]);
                .toArray(String[]::new);//메서드참조

        System.out.println(Arrays.toString(selected));
        /*
        * 사과
        * 배
        * 오렌지
        * 포도
        * [오렌지, 포도]
        * */
    }
}
