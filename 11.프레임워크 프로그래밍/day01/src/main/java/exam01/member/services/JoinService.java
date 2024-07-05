package exam01.member.services;

import exam01.member.controllers.RequestJoin;
import exam01.member.dao.MemberDao;
import exam01.member.entities.Member;
import exam01.member.validators.JoinValidator;

import java.time.LocalDateTime;

public class JoinService {
    private JoinValidator validator;
    private MemberDao memberDao;

    /*
    //연관 관계 - 없어도 객체 생성 가능
    //setter을 통한 주입
    public void setValidator (JoinValidator validator) {
        this.validator = validator;
    }
    */

    //의존관계 - 없으면 객체 생성 불가
    //생성자를 통한 주입
    public JoinService(JoinValidator validator, MemberDao memberDao) {
        this.validator = validator;
        this.memberDao = memberDao;
    }

    public void process(RequestJoin form){
        validator.check(form); //joinService는 validator 객체와 form 객체를 의존하고있다.
        // -> 의존성!!

        //데이터 영구 저장 - DAO(Data Access Object)
        Member member = Member.builder()
                        .email(form.getEmail())
                        .password(form.getPassword())
                        .userName(form.getUserName())
                        .regDt(LocalDateTime.now())
                        .build();
        memberDao.register(member);
    }
}
