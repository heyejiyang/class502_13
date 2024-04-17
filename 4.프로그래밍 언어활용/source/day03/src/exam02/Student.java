package exam02;

public class Student {
    static int id; //고정된 정적 변수
    private String name="이름정의";
    private String subject;

    public  Student(){}
    public Student(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }//생성자를 통해 초기화

    public static void staticMethod(){
        System.out.println("정적메서드!");
        //객체와 상관없이 사용 가능, this 지역변수 X => 객체의 자원에 접근 X
        //name = "홍길동"// this없어서 사용불가
        //instanceMethod(); // 접근 불가
    }
    public void instanceMethod(){
        System.out.println("인스턴스 메서드는 객체 필요!");
        System.out.println(this.name);
        //this 지역변수 O => 객체자원 접근
        staticMethod(); //인스턴스 메서드에서 정적 메서드 접근은 가능함.
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
