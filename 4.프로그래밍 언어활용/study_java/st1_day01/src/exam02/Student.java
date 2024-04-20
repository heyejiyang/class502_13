package exam02;

public class Student {//클래스명 Student - 설계명세

    //변수와 함수 '정의' 들어가는 곳
    /* 아직 변수 아님!!! 나중에 객체가 되면 값을 대입할것이라고 정의 해둔것
    * 다른 말로 멤버 변수 정의
    * */
    int id; //학번
    String name; //학생이름 문자열
    String subject;//전공 과목

    //함수(기능)정의
    void study(){ //메서드(클래스에 정의된 함수)
        System.out.printf("학번: %d, 이름: %s, 전공과목: %s\n",id, name, subject);
    }



}
