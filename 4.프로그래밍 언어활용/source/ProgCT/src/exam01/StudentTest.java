package exam01;

public class StudentTest {
    public static void main(String[] args) {
            Student s1 = new Student("홍길동",180100);
            Student s2 = new Student("김롸롸",170200);


       s1.showInfo();
       s2.showInfo();

    /*
    * 결과
    * 이름:홍길동, 학번:180100, 카드번호:180200
      이름:김롸롸, 학번:170200, 카드번호:170300
    * */


    }
}
