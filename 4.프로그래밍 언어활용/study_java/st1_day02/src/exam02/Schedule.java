package exam02;

public class Schedule {
    private int year; //변수 x 정의 o
    private int month;
    private int day;

    //get + 멤버 변수명


    //외부에서 접근가능한
    public void setYear(int _year){ //객체가 됐을때 실행되는 메서드
        year = _year;
    }

    //get + 멤버 변수명
    public int getYear(){
        return year;
    }
    public void setMonth(int _month){ //실행시점에는 객체가 되어있어야 실행되는것
        month = _month;
    }
    public int getMonth(){
        return month;
    }
    public void setDay(int _day){
        if(month == 2 && _day >28){
            _day = 28; //2월에 28일이 넘어가면 28로 고정시켜버리기
        }
        day = _day;
    }
    public int getDay(){
        return day;
    }


    void showInfo(){
        System.out.printf("year=%d, month=%d, day= %d\n",year,month,day);
    }
    void printThis(){
        System.out.println(this);
    }

}
