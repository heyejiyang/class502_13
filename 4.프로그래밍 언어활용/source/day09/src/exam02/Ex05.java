package exam02;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //System.out.print("숫자를 포함하여 입력: ");
        System.out.print("숫자만 입력: ");
        String str = scan.nextLine();

        //Pattern p1 = Pattern.compile("[0-9]"); //숫자포함

        //숫자만 입력하게끔
        //Pattern p1 = Pattern.compile("[^0-9]"); //숫자 아닌 모든것
        Pattern p1 = Pattern.compile("[\\D]");
        //자바에선 컴파일러가 인식할수있게끔 \를 두개 작성해야한다.
        Matcher m1 = p1.matcher(str);
        if(m1.find()){ //숫자가 아닌 문자 입력시
            System.out.println("숫자만 입력해주세요.");
        }
    }
}
