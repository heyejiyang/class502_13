package exam01;

public class Book {
    private int isbn;
    private String title;

    //생성자와 toString 정의

    public Book(){

    }

    public Book(int isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                '}';
    }
}
