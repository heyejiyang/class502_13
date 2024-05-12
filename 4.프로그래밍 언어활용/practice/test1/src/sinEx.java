public class sinEx {
    public static void main(String[] args) {
        Single s1 = Single.singlemethod();
        Single s2 = Single.singlemethod();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
    }
}
