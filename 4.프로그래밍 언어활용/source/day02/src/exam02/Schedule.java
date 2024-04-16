package exam02;

public class Schedule {
    private int year;
    private int month;
    private int day;


    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        if(month == 2 && day>=30){
            day = 28;
        }
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    void showData() {
        System.out.printf("%d년 %d월 %d일\n", year, month, day);
    }
}
