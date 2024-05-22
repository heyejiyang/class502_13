package member;

import java.awt.print.Book;
import java.time.LocalDateTime;

public class User {
    //내부에서 객체 생성 목적

    private String userId;
    private String userNm;
    private String email;
    private LocalDateTime regDt;

    private User(){

    } //기본 생성자 접근 통제

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userNm='" + userNm + '\'' +
                ", email='" + email + '\'' +
                ", regDt=" + regDt +
                '}';
    }

    public static Builder builder(){

        return new Builder(); //Builder 클래스 객체 반환
    }

    //내부에 정적 클래스 정의 (객체 만들고 값 설정)
    public static class Builder{ //내부에서 빌더클래스를 통해서 객체 생성해서 반환해줄거임
        private User user = new User(); //객체생성
        public Builder userId(String userId){
            user.userId = userId; //값 설정
            return this; //builder는 메서드 체이닝방식 -> (this) 같은 객체를 연달아 반환
        }
        public Builder userNm(String userNm){
            user.userNm = userNm;
            return  this;
        }
        public Builder email(String email){
            user.email = email;
            return  this;
        }
        public Builder regDt(LocalDateTime regDt){
            user.regDt = regDt;
            return  this;
        }
        public User build(){ //완성된 객체 내보냄
            return user;
        }
    }
}
