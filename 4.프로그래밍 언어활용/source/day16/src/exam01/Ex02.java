package exam01;

import java.util.Random;

public class Ex02 {
    public static void main(String[] args) {
        Random rand = new Random();
        int firstOdd = rand.ints(100)
                .filter(x -> x % 2 == 1)
                .findFirst()
                .orElse(-1);
        //무작위 난수중 홀수가 없는 경우도 배제할 수는 없다. 우연히 다 짝수일수도..
        //findFirst에서 반환 할 요소가 없을수도 있다는 얘기!!
        //값이 없는 경우 -1 반환하도록 orElse 추가

        System.out.println(firstOdd); //무작위 난수 출력
    }
}
