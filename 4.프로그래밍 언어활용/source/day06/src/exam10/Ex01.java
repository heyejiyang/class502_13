package exam10;

public class Ex01 {
    public static void main(String[] args) {
        Outer o = new Outer();
        Calculator ca = o.method();
        System.out.println(ca.add(20,30));
        System.out.println(o.method().add(10,20));
    }
}
