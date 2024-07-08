package member.services;


import member.dao.MemberDao;
import member.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class InfoService {//회원목록 조회

    private MemberDao memberDao;
    private DateTimeFormatter formatter;

    @Autowired
    public void setMemberDao(Optional<MemberDao> opt) {
        this.memberDao = opt.get();
    }

//    @Autowired(required = false) //DateTimeFormatter bean이 없으면 호출 X
//    public void setFormatter(DateTimeFormatter formatter) {
//        System.out.println("호출!"); //호출 안됨
//        this.formatter = formatter;
//    }

    @Autowired
    public void setFormatter(@Nullable DateTimeFormatter formatter) {
        System.out.println("호출!"); //호출 됨
        this.formatter = formatter;
    }


    public void printList(){
        List<Member> members = memberDao.getList();
        members.forEach(m -> {
            System.out.println(m);
            LocalDateTime regDt = m.getRegDt();
            if(formatter != null){
                System.out.println(formatter.format(regDt));
            }

        });
    }
}
