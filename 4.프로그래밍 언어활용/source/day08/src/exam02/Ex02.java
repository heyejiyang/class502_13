package exam02;

public class Ex02 {
    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "ABC";
        System.out.println(s1==s2);
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
    }
}
