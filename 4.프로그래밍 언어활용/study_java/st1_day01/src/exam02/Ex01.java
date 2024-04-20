package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student();//new 메모리에 생성 -> 변수들이 실제 공간을 할당받게 된다.

        s1.id = 1011; //설계도에 불과했던 애들이 값 대입받고 변수가 되었다!
        s1.name="홍길동"; // 메모리에 존재하게 된다. (실체가 됨)
        s1.subject="정보통신";//인스턴스 = 생성된 객체

        s1.study();// 함수 기능 수행

        System.out.println(System.identityHashCode(s1)); //객체의 주소값 출력

        //하나의 클래스로 객체를 여러개 만들 수 있다. 각각 다른 메모리에 생성된다.
        Student s2 = new Student(); //s1과 다른 객체이다. 주소도 다르고 자원 접근도 다름
        s2.id = 1200;
        s2.name = "김수한";
        s2.subject = "컴공";
        s2.study();
        System.out.println(System.identityHashCode(s2));

        Student s3 = s2; //s2 주소값 복사
        s3.name = "이름 바꿈";
        s3.study();
        s2.study(); //s3을 바꿔도 s2의 내용 또한 바뀐다.

        System.out.println(s2 == s3);//주소비교, 동일성 비교 => true

        s1= null; //참조가 끊긴다. 접근 불가
        //힙에 있는 메모리를 쓰지않고 참조가 끊겨버리면 자원들 제거해버린다. -> Garbage Collector: 메모리 해제
    }
    /*
    * 함수는 제거되는 임시 메모리가 필요하지만
    * 객체는 별도의 힙이라는 메모리가 필요하다 - 제거x
    * */
}
