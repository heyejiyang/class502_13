package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex09 {
    public static void main(String[] args) {
        String mobile = "010-2525-8282";
        System.out.println(checkMobile(mobile));
    }
    public static boolean checkMobile(String mobile){//전화번호
        /*
        * 010-2525-8282
        * 011-000-0000
        * 016-000-0000
        * */
        //^ 시작하는 패턴 명시, 이걸 안넣어주면 앞에 다른 문자를 넣어도 패턴이 맞다고 인식
        //01[016]문자 한개한개 매칭
        //\d{3,4} 숫자패턴 3자리에서4자리
        //\d{4} 네자리
        //끝나는쪽에 4자리로 끝난다고 알려줘야한다 $ 끝나는 패턴
        // 전화번호 입력시 중간에 - 표시 대신 다른거 해줄때 \D* : 숫자 다음 문자가 있어도 되고 없어도 된다
        Pattern pattern = Pattern.compile("^01[016]\\D*\\d{3,4}\\D*\\d{4}$");
        Matcher matcher = pattern.matcher(mobile);
        boolean matched = matcher.find();
        return matched;
    }
}
