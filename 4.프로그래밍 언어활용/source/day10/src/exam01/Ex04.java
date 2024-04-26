package exam01;

public class Ex04 {
    public static void main(String[] args) {
        Transportation trans = Transportation.TAXI;
        String str = trans.name();//상수명 그대로 문자열로 바꿈
        // => trans.toString()
        System.out.println(str); //TAXI

        int ordinal = trans.ordinal();
        System.out.println(ordinal); //상수의 위치번호 //Bus:0, Subway:1, Taxi:2
        //순서를 바꾸면 바뀔 수 있다., 내부적으로만 쓰임

        //문자열 데이터를 다시 enum상수로 바꿈
        String trans1 = "BUS";
        //Transportation BUS = Enum.valueOf(Transportation.class,trans1);
        //trans1문자열을 가지고 어떤 enum함수의 형태로 바꿔줄지 참고하기 위해 class메서드가 있음
        //System.out.println(BUS.name());
        Transportation BUS = Transportation.valueOf(trans1); //더 많이 씀

    }
}
