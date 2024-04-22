package exam08;

public class Outer {
    int num1 = 10;
    static int num2 = 20;
    static class Inner{
        public void method(){
            System.out.println("정적 내부 클래스에서 호출");
            //System.out.println(num1); Outer클래스의 객체가 되든 관련 X, 접근 x
            System.out.println(num2);
        }
    }
}
