public class Ex01 {
    public static void main(String[] args) {
        Person p1 = new Person("홍길동","아메리카노");
        Person p2 = new Person("김수한","라테");
        MegaCoffee m1 = new MegaCoffee();
        ComposeCoffee c1 = new ComposeCoffee();


        p1.Mega_Cafe(m1);
        m1.showInfo();

        p2.Compose_Cafe(c1);
        c1.showInfo();
    }
}
