package exam01;

import java.util.Optional;

public class Ex09 {
    public static void main(String[] args) {
        Book book = null;
        Optional<Book> opt = Optional.ofNullable(book);
        //Book book2 = opt.orElseGet(()-> new Book());//매개변수 x 반환값 o
        //메서드 참조
        Book book2 = opt.orElseGet(Book::new);
        System.out.println(book2); //Book{isbn=0, title='null'}


    }
}
