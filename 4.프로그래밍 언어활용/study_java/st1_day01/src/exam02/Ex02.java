package exam02;

public class Ex02 {
    public static void main(String[] args) {
        //프로그램이 시작되면 main메서드먼저 실행된다. 항상!

        int result = add(10,20);
        //System.out.println(result);
    }

    static int add(int num1,int num2){
        //함수 지역
        int result = num1+num2;
        return result;
    }
}
