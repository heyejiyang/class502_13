package exam02;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("문장을 입력하세요: ");

        String str = scan.nextLine();
        //Pattern p1 = Pattern.compile("[a-z]");//메타 문자'-' a부터 z까지
        //대문자 구분 불가능
        //범위 넓히기
        Pattern p1 = Pattern.compile("[a-z]",Pattern.CASE_INSENSITIVE);//알파벳 대소문자 구분 없이 체크
        Matcher m1 = p1.matcher(str);
        if(!m1.find()){
            System.out.println("문장에 알파벳이 포함되지 않았습니다.");
            System.out.println("문장에 알파벳을 포함해주세요.");
        }
    }
}
