package exam01;

import lombok.*;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor(access = AccessLevel.PRIVATE) //private 범위의 생성자 추가
//@AllArgsConstructor // 모든 멤버변수 초기화 생성자
//@RequiredArgsConstructor
//@EqualsAndHashCode
//@Data //@Getter + @Setter + @ToString + @EqualsAndHashCode
public class Book {
    private  String title;
    private String author;
    private String publisher;

    private Book(){}

    public static Builder builder(){
        return new Builder(); //정적 메서드 통해서 객체 반환
    }

    static class Builder{ //내부에서 빌더 통해서 객체 생성
        private Book b = new Book();

        public Builder title(String title){
            b.title = title;
            return this; //builder는 메서드 체이닝방식 같은 객체를 연달아 반환
        }

        public Builder author(String author){
            b.author = author;
            return this;
        }
        public Builder publisher(String publisher){
            b.publisher = publisher;
            return this;
        }
        public Book build(){
            return b;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
