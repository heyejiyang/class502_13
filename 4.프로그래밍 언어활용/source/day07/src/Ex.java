public class Ex {
    public static void main(String[] args) {
        String str = "ABC"; //문자열 상수이자 객체
        System.out.println(System.identityHashCode(str)); //처음 주소
        str += "DEF";
        System.out.println(System.identityHashCode(str)); //바뀔때마다 주소가 바뀐다
        str += "GHI";
        System.out.println(System.identityHashCode(str)); //바뀐다!

        System.out.println(str); //문자열 결합됨
    }
}
