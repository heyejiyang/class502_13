package ex197_5;

public class Ex05 {
    public static void main(String[] args) {
        Person p1 = new Person("김씨",4000);
        Person p2 = new Person("이씨",4500);

        Star_Cafe cafe1 = new Star_Cafe();
        Cong_Cafe cafe2 = new Cong_Cafe();

        System.out.println("--김씨 주문--");
        p1.star_Cafe(cafe1);
        System.out.println("--이씨 주문--");
        p2.cong_Cafe(cafe2);

    }
}
