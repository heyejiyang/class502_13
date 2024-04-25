package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex01 {
    public static void main(String[] args) {
        String str = " I miss you sungjun cute sungjuni";

        Pattern p1 = Pattern.compile("sungjun");
        Matcher m1 = p1.matcher(str);

        System.out.println(m1.find()); //true -> sungjun
        System.out.println(m1.group()); //패턴에 일치하는 문자열 가져옴 -> sungjun
        System.out.println(m1.find()); //true -> sungjuni
        System.out.println(m1.group()); //패턴에 일치하는 문자열 -> sungjun
        System.out.println(m1.find()); //false -> 없음
        //System.out.println(m1.group()); //에러 No match found
    }
}
