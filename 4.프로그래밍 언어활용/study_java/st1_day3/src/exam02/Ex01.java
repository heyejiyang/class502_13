package exam02;

public class Ex01 {
    public static void main(String[] args) {
       // B b = new B(); //객체 생성 -> 자원 접근 가능
        //System.out.println(b.numA);//하위클래스에서 상위클래스 자원 접근 가능

        C c = new C();

        A a = c; //A에 c를 담는다
        B b = c; //B에 c를 담는다
        //하위클래스가 상위클래스로 바뀐다 C -> B,A 클래스로 자동 형변환( 다형성 )

        B bc = new C();

    }
}
