package exam05;

public class Outer {
//    int num1 = 30;
//    int num2 = 20;
    static int num=20;
    class Inner{
        //int num1 = 10;
        static int num=10;
        void method(){
//            System.out.println("인스턴스 내부 클래스!");
//            System.out.println(this.num1);
//            System.out.println(num2);
//            System.out.println("Outer.num1: "+ Outer.this.num1);
            System.out.println("Inner static: "+ Inner.num);
            System.out.println("Outter static: "+ Outer.num);

        }
        static void staticMethod(){
            System.out.println("정적 메서드!");
        }
    }
}
