package Level1.solution12916;

public class Solution3 {
    boolean solution(String s) {
//        s = s.toLowerCase(); //문자열 소문자로
//        int count = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//
//            if (s.charAt(i) == 'p')
//                count++;
//            else if (s.charAt(i) == 'y')
//                count--;
//        }
//
//        if (count == 0) //p와 y의 포함 개수가 같으면 ++ 하고 -- 해줬으므로 무조건 0 값이 나올거임 p와 y 를 포함 하지 않고 있어도 0 이 나올것
//            return true;
//        else //한개라도 차이가 있으면 0 이 나오지 않음
//            return false;

        s = s.toUpperCase();

        int count = 0;

        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == 'P'){
                count++;
            }else if(s.charAt(i) == 'Y'){
                count--;
            }
        }

        if(count != 0){
            return false;
        }
        return true;
    }
}
