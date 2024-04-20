package exam03;

public class HighSchoolStudent extends Student{
    //부모클래스에 생성자가 정의된 상태, 컴파일러는 자동으로 생성자를 생성해주지 않는다. 이미 객체를 만들 생성자가 정의되어 있기 때문
    // 모든 생성자 첫번째 줄에는 super()가 숨어있는데 super은 상위클래스의 기본!!!!생성자를 참고한다
    // 현재 부모클래스에는 기본생성자가 없기때문에 오류가뜬다.
    /*public HighSchoolStudent(){

    }*/

    //해결 1. 상위 클래스에서 기본 생성자를 추가하거나
    //해결 2. 매개변수가 있는 super로 바꾸거나
    public HighSchoolStudent(){
        super(1111,"홍길동");
    }
    @Override
    public String toString() {
        return "HighSchoolStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
