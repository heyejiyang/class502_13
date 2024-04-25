package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex02 {
    public static void main(String[] args) {
        String str = " I miss you sungjun cute sungjuni";

        Pattern p1 = Pattern.compile("sungjun");
        Matcher m1 = p1.matcher(str);
        boolean match = m1.matches();
        System.out.println(match); //false

        String str2 = "sungjun"; //정확히 패턴이 일치해야 true
        Pattern p2 = Pattern.compile("sungjun");
        Matcher m2 = p2.matcher(str2);
        boolean match2 = m2.matches();
        System.out.println(match2); //true
    }
}
