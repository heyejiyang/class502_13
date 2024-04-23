package exam01;

public class Ex {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        System.out.println(System.identityHashCode(sb));
        sb.append("ABC");//내부 버퍼에 쌓인다.
        sb.append("DEF");
        sb.append("GHI");
        System.out.println(System.identityHashCode(sb)); //처음 주소와 같음

        //문자열 꺼낼때 새로운 객체 만들어짐
        String str = sb.toString();
        System.out.println(str);
        System.out.println(System.identityHashCode(str)); //주소 다름
        System.out.println(str == "ABCDEFGHI"); //false, 객체와 문자열 상수비교 nono 다른객체임!!

        //문자열은 무조건 equals로 비교!!
        System.out.println(str.equals("ABCDEFGHI"));

    }
}
