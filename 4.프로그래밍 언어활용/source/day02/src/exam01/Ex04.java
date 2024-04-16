package exam01;

public class Ex04 {
    public static void main(String[] args) {
        System.out.println(add(1,2));
        System.out.println(add(2,4,5));
        System.out.println(add(3.0,5.0));

    }

    static int add(int num1, int num2){
        return num1+num2;
    }

    static int add(int num1, int num2, int num3){
        return num1+num2+num3;
    }

    static double add(double num1, double num2){
        return num1+num2;
    }
}
