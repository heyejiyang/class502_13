package exam01;

import java.util.Random;

public class Ex02 {
    public static void main(String[] args) {
        Random rand = new Random();

        //rand.ints(6).forEach(System.out::println);//난수 6개 정수범위에서 출력
       rand.ints().limit(6).forEach(System.out::println);
    }
    /**
     * -1440999230
     * -895957429
     * -1102137881
     * -771124964
     * -194581035
     * -434621603
     * */
}
