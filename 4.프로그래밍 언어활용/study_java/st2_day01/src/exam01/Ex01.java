package exam01;

public class Ex01 {
    public static void main(String[] args) {
        //Calculator cal = new Calculator();
        Calculator cal = new SimpleCalculator();
        int result = cal.add(100,20);
        System.out.println(result);
        System.out.println(cal.num);
        cal.commonMethod();
    }
}
