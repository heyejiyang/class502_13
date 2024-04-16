package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Schedule s1 = new Schedule();
        //s1.year = 2024;
        //s1.month = 2;
        // s1.day = 31;

        s1.setYear(2024);
        s1.setMonth(2);
        s1.setDay(31);
        s1.showData();


        //s1.month; //private이라 접근 불가

        int month = s1.getMonth();
        System.out.println("몇월이냐 -> "+month);
    }
}

