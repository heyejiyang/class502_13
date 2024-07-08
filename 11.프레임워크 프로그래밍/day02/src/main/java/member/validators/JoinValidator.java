package member.validators;


import global.validators.Validator;
import member.controllers.RequestJoin;
import member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //관리 할 객체임을 알려줌
public class JoinValidator implements Validator<RequestJoin> {
    private MemberDao memberDao;

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }


    @Override
    public void check(RequestJoin form) {

    }
}
