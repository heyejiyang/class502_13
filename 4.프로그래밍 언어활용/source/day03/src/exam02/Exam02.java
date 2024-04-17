package exam02;

public class Exam02 {
    public static void main(String[] args) {
        Student.id = 10111; //객체 생성과 관련 x
        System.out.println(Student.id);

        Student.staticMethod(); //객체생성과 관련 x
    }
}
