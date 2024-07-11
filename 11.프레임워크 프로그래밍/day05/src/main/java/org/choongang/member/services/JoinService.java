package org.choongang.member.services;


import lombok.RequiredArgsConstructor;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.validators.JoinValidator;
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
