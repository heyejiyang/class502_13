package exam03;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex03 {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd a hh:mm");

        String strDate = sdf.format(date);
        //date 객체 사용해서 형식화된 데이터로 출력
        System.out.println(strDate); //2024.05.09 오후 04:29
    }
}
