package exam03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex04 {
    public static void main(String[] args) throws ParseException {
        String strDate = "31/05/23 00:00";

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm");

        Date date = sdf.parse(strDate); //예외전가시키기

        System.out.println(date); //Wed May 31 00:00:00 KST 2023
    }
}
