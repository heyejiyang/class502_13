package exam01;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private int isbn; //도서번호
    private String title; //도서명
    private String author; //저자


    public Book(int isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book){
            Book book = (Book) obj;
            if(isbn == book.isbn && title.equals(book.title) && author.equals(book.author)){
                return true; //값이 같으면 같은 책이라고 true 반환
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author);
    }

    @Override
    public int compareTo(Book o) {
        //return isbn - o.isbn; // isbn 기준 오름차순( 현채객체 - 비교대상 객체 )
        return  o.isbn - isbn; //내림차순( 비교대상객체 - 현재객체)
    }
}
