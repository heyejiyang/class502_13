package exam01;

import lombok.*;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor(access = AccessLevel.PRIVATE) //private 범위의 생성자 추가
//@AllArgsConstructor // 모든 멤버변수 초기화 생성자
//@RequiredArgsConstructor
//@EqualsAndHashCode
@Data //@Getter + @Setter + @ToString + @EqualsAndHashCode
public class Book {
    private  String title;
    private String author;
    private String publisher;

}
