package org.choongang.member.services;
import org.choongang.global.validators.Validator;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.mapper.MemberMapper;

//회원가입 기능
public class JoinService {
    private Validator<RequestJoin> validator;
    private MemberMapper mapper;

    public JoinService(Validator<RequestJoin> validator, MemberMapper mapper) {
        this.validator = validator;
        this.mapper = mapper;
    }

    public void process(RequestJoin form){
//        String email = form.getEmail();
//        if(email == null || email.isBlank()){
//            throw new BadRequestException("이메일을 입력하세요");
//        }
        //유효성 검사
        validator.check(form);  //예외발생안하면 검증 성공
    }
}
