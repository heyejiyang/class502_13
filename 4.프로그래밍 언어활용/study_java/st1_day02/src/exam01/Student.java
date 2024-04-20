package exam01;

public class Student {
    static int id;
    String name;
    String subject;

    public Student(int _id, String _name, String _subject){
        /*
        * 목적은 객체를 생성하는게 목적이다.
        * 반환 타입이 명시되어 있지 않다 ?
        * 생성자 함수는 반환값이 객체의 주소값으로 정해져있다
        * 멤버 변수의 초기화 작업을 주로 진행한다.
        * */
        id = _id;
        name = _name;
        subject= _subject;

    }

    void showInfo(){
        System.out.printf("id=%d, name=%s, subject=%s\n",id,name,subject);
    }
}
