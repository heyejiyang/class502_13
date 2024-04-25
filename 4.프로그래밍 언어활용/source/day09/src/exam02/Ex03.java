package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex03 {
    public static void main(String[] args) {
        String str = "123 a123 efg 12b3";
        Pattern p1 = Pattern.compile("[abc]"); //a,b,c 문자 각각 한개씩 체크
        Matcher m1 = p1.matcher(str);
        if (m1.find()) {
            System.out.println(m1.group()); //a123에 a 찾음
        }
        if (m1.find()) {
            System.out.println(m1.group());//두번째로 이동 12b3에 b찾음
        }

    }
}
