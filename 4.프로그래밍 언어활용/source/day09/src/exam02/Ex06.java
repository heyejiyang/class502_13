package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex06 {
    public static void main(String[] args) {
        String str = "juni! I like juni and junicute";
        //Pattern p1 = Pattern.compile("\\bjuni\\b");
        Pattern p1 = Pattern.compile("\\bjuni\\B"); //sungjuni
        Matcher m1 = p1.matcher(str);
        if(m1.find()){
            System.out.println(m1.group()); //junicute매칭
        }
        m1.find();
        System.out.println(m1.group()); //No match found
    }
}
