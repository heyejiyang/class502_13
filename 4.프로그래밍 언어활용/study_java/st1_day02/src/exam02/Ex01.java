package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Schedule s1 = new Schedule(); // 객체 생성

        /*
        s1. year = 2024; //인스턴스
        s1.month = 2;
        s1.day = 31; //변수 대입 자체는 통제하지 못하는데.. 어케 막을까!
        //멤버변수에 값을 직접 다입하게 되면 이런일을 막을 수 없다.
        */

        s1.setYear(2024); //인스턴스 메서드, 멤버 메서드 - 객체가 되어야 접근가능
        s1.setMonth(2);
        s1.setDay(31);

        s1.showInfo();

        //s1.month; //못가져옴 private
        int month = s1.getMonth();
        System.out.println(month);
        //값을 가져오고 조회 할수 있는 메서드가 완성되었다.
    }
}
