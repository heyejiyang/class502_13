package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Book b1 = new Book(1000,"책1","저자1");
        Book b2 = new Book(1000,"책1","저자1");
        System.out.printf("b1 == b2: %s%n",b1==b2);
        System.out.printf("b1주소:%d%n",System.identityHashCode(b1));
        System.out.printf("b2주소:%d%n",System.identityHashCode(b2));
        System.out.printf("str1.equals(str2):%s%n",b1.equals(b2));
    }
}
