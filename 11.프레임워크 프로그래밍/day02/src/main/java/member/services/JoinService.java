package member.services;


import member.controllers.RequestJoin;
import member.dao.MemberDao;
import member.entities.Member;
import member.validators.JoinValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JoinService {

    @Autowired //자동 의존성 주입
    private JoinValidator validator;

    @Autowired
    private MemberDao memberDao;



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
