package exam01;

public class Ex02 {
    public static void main(String[] args) {
        Student s1 = new Student(1234,"내이름","과목임"); //생성자 함수에 값 초기화 되어있음
        s1.showInfo();

        Student s2 = new Student(7890,"너이름","수학");
        s2.showInfo();
        System.out.println(s1==s2); //주소 다름
    }
}
