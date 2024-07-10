package member.services;

import global.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import mappers.member.MemberMapper;
import member.controllers.RequestJoin;
import member.entities.Member;
import member.validators.JoinValidator;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //의존성 추가 완료
public class JoinService {
    private final JoinValidator validator;
    public final MemberMapper mapper;

    public void process(RequestJoin form){
        validator.check(form); //유효성 검사

        //유효성 검사 끝났으면 하단 코드 실행
        //비밀번호 해시화
        String hash = BCrypt.hashpw(form.getPassword(),BCrypt.gensalt(12));//반복횟수 12번

        //DB저장
        Member member = Member.builder()
                .email(form.getEmail())
                .password(hash)
                .userName(form.getUserName())
                .build();
        int result = mapper.register(member);
        if(result < 1){
            throw new BadRequestException("회원가입 실패!");
        }
    }
}
