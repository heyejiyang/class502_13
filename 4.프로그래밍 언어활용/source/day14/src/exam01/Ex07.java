package exam01;

import java.util.function.Supplier;

public class Ex07 {
    public static void main(String[] args) {
        Supplier<Book> s1 = () -> new Book(); //반환값만 있는 인터페이스 Supplier

        //한줄에 Book객체만 만들어서 나가는데 더 짧게 해줄까... 어차피 반환값은 Book
        Supplier<Book> s2 = Book::new;

        Book b1 = s2.get();
        System.out.println(b1);
    }
}
