package exam02;

public class Ex03 {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c instanceof C); //c객체가 C클래스의 객체인가 출처 확인
        System.out.println(c instanceof B); //B클래스를 상속하는중, A클래스도.... true
        System.out.println(c instanceof A); //true
        System.out.println(c.numA);
    }
}
