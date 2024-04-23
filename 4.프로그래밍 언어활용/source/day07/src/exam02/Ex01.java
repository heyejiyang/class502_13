package exam02;

public class Ex01 {
    public static void main(String[] args) {
        try {
            int num1 = 10;
            int num2 = 2;
            int result = num1 / num2;

            String str = null;
            System.out.println(str.toUpperCase()); //NullPointerException 예외 발생

            System.out.println(result);
        }catch(ArithmeticException e) {
            e.printStackTrace();
        }catch (Exception e){ //예외를 모를때 상위클래스인 Exception으로 감싸서 처리
            //다형성!!
            System.out.println("유입");
            e.printStackTrace();
        }
        System.out.println("매우 중요한 코드 ...");
    }
}
