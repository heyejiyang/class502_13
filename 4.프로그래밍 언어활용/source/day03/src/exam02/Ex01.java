package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student(1000,"홍길동","자바");
        Student s2 = new Student(2000,"김수한","코틀린");

        System.out.println("s1: "+s1);
        System.out.println("s2: "+s2);

        System.out.println(s1.id);//Student.id형태로 쓰기
        System.out.println(Student.id);
        s1.instanceMethod();
    }
}
