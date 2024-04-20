package exam01;

public class Ex04 {
    public static void main(String[] args) {
        //클래스에 현재 id 변수는 static으로 정의 해둔상태
        Student s1 = new Student(1000,"학생이름","과목1");
        s1.showInfo();
        Student s2 = new Student(4000, "학생이름쓰","과목2쓰");
        s2.showInfo();
        s1.showInfo();
    }
}
