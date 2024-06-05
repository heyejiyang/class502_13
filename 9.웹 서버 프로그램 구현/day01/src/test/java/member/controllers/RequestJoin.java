package member.controllers;


import lombok.Builder;
import lombok.Data;

@Data //setter getter toString equals hashcode
@Builder //setter getter 대신
public class RequestJoin {
    private String userName; //사용자 이름
    private String email; //아이디는 이메일로 입력하도록
    private String password;
    private String confrimPw; //비밀번호 확인
    private boolean termsAgree;//약관동의
}
