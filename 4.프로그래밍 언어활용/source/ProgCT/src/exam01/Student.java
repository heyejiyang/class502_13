package exam01;

public class Student {
    private int studentNum;
    private int cardNum;
    private String name;

    public Student(String name, int studentNum){
        this.name = name;
        this.studentNum = studentNum;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public int getCardNum() {
        return studentNum+100;
    }

    public String getName() {
        return name;
    }
    public void showInfo(){
        System.out.printf("이름:%s, 학번:%d, 카드번호:%d%n",getName(),getStudentNum(),getCardNum());
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNum=" + studentNum +
                ", cardNum=" + cardNum +
                ", name='" + name + '\'' +
                '}';
    }
}
