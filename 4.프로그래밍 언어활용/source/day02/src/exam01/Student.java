package exam01;

public class Student {

    int id;
    String name;
    String subject;

    public  Student(){};

    public Student(int _id, String _name, String _subject){
        System.out.println("객체 생성 이후 실행");
        id = _id;
        name =_name;
        subject=_subject;
    }

    void study() {
        System.out.printf("%s가 %s를 공부한다.\n", name, subject);
    }

}
