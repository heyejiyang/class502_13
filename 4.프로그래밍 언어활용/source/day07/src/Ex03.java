public class Ex03 {
    public static void main(String[] args) {
        String str1 = new String("가나다");
        String str2 = new String("가나다");
        System.out.println(str1 == str2); //동일성 비교 false, 주소 다름
        System.out.printf("str1주소: %d",System.identityHashCode(str1));
        System.out.printf("str2주소: %d",System.identityHashCode(str2));
    }
}
