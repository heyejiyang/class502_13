package exam01;

import java.util.StringTokenizer;

public class Ex04 {
    public static void main(String[] args) {
        String fruits = "Apple#Orange_Melon,Banana+Mango"; //토큰을 #로 설정
        StringTokenizer st = new StringTokenizer(fruits,"#,_+");
        //구분문자를 기준으로 분해해서 가져온다.
        //토큰이 많을때는 그냥 옆에 나열해서 입력하면 된다.

        //토큰이 존재하는지 체크, 커서 이동하면서 쪼개서 확인
        while (st.hasMoreElements()){
            //hasMoreTokens() 메서드는 StringTokenizer 객체 내의 토큰을 하나씩 확인하면서
            //아직 처리하지 않은 토큰이 있으면 true를 반환하고, 모든 토큰을 다 확인했으면 false를 반환
            String fruit = st.nextToken();
            System.out.println(fruit);
        }
    }
}
