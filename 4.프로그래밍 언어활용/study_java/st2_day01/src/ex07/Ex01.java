package ex07;

public class Ex01 {
    public static void main(String[] args) {
        Outer out = new Outer();
        Calculator cal = out.method(50);
        int result = cal.add(10,40);
        System.out.println(result);
    }
}
