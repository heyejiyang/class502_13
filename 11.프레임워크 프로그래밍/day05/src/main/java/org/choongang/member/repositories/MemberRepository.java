package org.choongang.member.repositories;

import org.choongang.member.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {
    //회원조회
    Member findByEmail(String email); //구현체를 만들어주고 이 패턴에 맞게 조회해준다// .
    Page<Member> findByUserNameContaining(String keyword, Pageable pageable);
    List<Member> findByUserNameContainingAndEmailContainingOrderByRegDtDesc(String key1, String key2);//정렬 추가


    @Query("SELECT * FROM MEMBER WHERE USER_NAME LIKE :param1 AND EMAIL LIKE :param2 ORDER BY REG_DT DESC") //param이 대체되는 부분
    List<Member> getMembers(@Param("param1")String key1, @Param("param2")String key2);
    //param1 -> key1, param2 -> key2
}
