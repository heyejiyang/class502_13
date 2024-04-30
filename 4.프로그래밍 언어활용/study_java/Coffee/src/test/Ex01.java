package test;

public class Ex01 {
    public static void main(String[] args) {
        Person p1 = new Person("홍길동", "아메리카노");
        Person p2 = new Person("김수한", "라테");
        Cafe megaCoffee = new MegaCoffee();
        Cafe composeCoffee = new ComposeCoffee();

        p1.visitCafe(megaCoffee);
        p2.visitCafe(composeCoffee);
    }
}
