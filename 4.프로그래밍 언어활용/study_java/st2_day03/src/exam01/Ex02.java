package exam01;

public class Ex02 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = sb.append("ABC");
        sb.append("ABC").append("DEF").append("GHI");
        System.out.println(System.identityHashCode(sb));

        String str = sb.toString();
        System.out.println(str);
        System.out.println(System.identityHashCode(str));
    }
}
