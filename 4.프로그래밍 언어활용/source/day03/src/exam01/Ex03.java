package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Schedule s1 = new Schedule(2024,3,20);

        System.out.println(s1);//16진수로 주소 표현
        //내부적으로 s1.toString();이 호출된다.
        //System.out.println(System.identityHashCode(s1));//int
    }
}
