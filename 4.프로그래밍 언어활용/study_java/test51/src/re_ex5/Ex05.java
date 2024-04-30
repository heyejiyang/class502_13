package re_ex5;

import ex197_5.Cong_Cafe;
import ex197_5.Star_Cafe;

public class Ex05 {
    public static void main(String[] args) {
        Person p1 = new Person("김씨", 4000);
        Person p2 = new Person("이씨", 4500);

        Cafe cafe1 = new Cafe("별다방", "아메리카노");
        Cafe cafe2 = new Cafe("콩다방", "라테");

        System.out.println("--김씨 주문--");
        cafe1.order(p1);
        System.out.println("--이씨 주문--");
        cafe2.order(p2);

    }
}
