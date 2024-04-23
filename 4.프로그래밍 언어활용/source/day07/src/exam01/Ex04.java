package exam01;

public class Ex04 {
    public static void main(String[] args) {
        A a = new A(){
            public void method() {
                System.out.println("main에서 재정의된 메서드!");
            }
        };// 생성과정 중 메서드 재정의
        a.method();
    }
}
