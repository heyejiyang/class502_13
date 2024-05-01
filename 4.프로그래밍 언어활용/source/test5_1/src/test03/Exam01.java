package test03;

public class Exam01 {
    public static void main(String[] args) {
        Person p1 = new Person("김씨","아메리카노");
        Person p2 = new Person("이씨","라테");

        Star s1 = new Star();
        Cong c1 = new Cong();

        p1.visitCafe(s1);
        p2.visitCafe(c1);

    }
}
